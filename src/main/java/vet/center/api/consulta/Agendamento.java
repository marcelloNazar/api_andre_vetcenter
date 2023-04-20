package vet.center.api.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.center.api.consulta.validacoes.ValidadorConsultas;
import vet.center.api.domain.ValidacaoExeption;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.veterinario.VeterinarioRepository;

import java.util.List;

@Service
public class Agendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private List<ValidadorConsultas> validadores;



    public DadosDetalhados agendar(DadosConsulta dados) {
        if (!animalRepository.existsById(dados.idAnimal())) {
            throw new ValidacaoExeption("id do animal não existe!");
        }
        if (!veterinarioRepository.existsById(dados.idVeterinario())) {
            throw new ValidacaoExeption("id do veterinario não existe!");
        }
        if (!produtoRepository.existsById(dados.idProduto())) {
            throw new ValidacaoExeption("id do produto não existe!");
        }

        validadores.forEach(v -> v.validar(dados));



        var veterinario = veterinarioRepository.findById(dados.idVeterinario()).get();
        var animal = animalRepository.findById(dados.idAnimal()).get();
        var produto = produtoRepository.findById(dados.idProduto()).get();

        var consulta = new Consulta(null, veterinario, animal, produto, dados.data());



        consultaRepository.save(consulta);

        return new DadosDetalhados(consulta);
    }

}
