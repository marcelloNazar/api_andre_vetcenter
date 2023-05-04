package vet.center.api.atendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.center.api.consulta.ConsultaRepository;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.servico.ServicoRepository;
import vet.center.api.domain.veterinario.Veterinario;
import vet.center.api.domain.veterinario.VeterinarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

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
    private ConsultaRepository consultaRepository;

    public void createAtendimento(DadosAtendimento dados) {


    }


}
