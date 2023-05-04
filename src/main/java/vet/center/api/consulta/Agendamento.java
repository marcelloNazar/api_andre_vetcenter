package vet.center.api.consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.center.api.consulta.validacoes.ValidadorConsultas;
import vet.center.api.domain.ValidacaoExeption;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.domain.servico.ServicoRepository;
import vet.center.api.domain.veterinario.VeterinarioRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Agendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

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
        var proprietario = proprietarioRepository.findById(dados.idProprietario()).get();
        var produto = produtoRepository.findById(dados.idProduto()).get();
        var servico = servicoRepository.findById(dados.idServico()).get();

        Map<String, Object> result = new HashMap<>();
        result.put("veterinario", veterinario);
        result.put("animal", animal);
        result.put("proprietario", proprietario);
        result.put("produto", produto);
        result.put("servico", servico);



        var consulta = new Consulta(null, veterinario, animal, proprietario, produto, servico, dados.data());



        consultaRepository.save(consulta);

        return new DadosDetalhados(consulta);
    }

}
