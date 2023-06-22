package vet.center.api.atendimento;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.animal.AnimalService;
import vet.center.api.domain.produto.*;
import vet.center.api.domain.servico.*;
import vet.center.api.domain.veterinario.VeterinarioService;
import vet.center.api.user.User;
import vet.center.api.user.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AtendimentoProdutoRepository atendimentoProdutoRepository;

    @Autowired
    private AtendimentoServicoRepository atendimentoServicoRepository;

    @Transactional
    public Atendimento createAtendimento(AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = new Atendimento();

        User veterinario = userRepository.findById(atendimentoDTO.getVeterinarioId())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: "));
        atendimento.setVeterinario(veterinario);
        Animal animal = animalService.getAnimalById(atendimentoDTO.getAnimalId());
        atendimento.setAnimal(animal);
        atendimento.setProprietario(animal.getProprietario());
        atendimento.setDateTime(LocalDateTime.now());
        atendimento = atendimentoRepository.save(atendimento);

        BigDecimal total = BigDecimal.ZERO;
        for (AtendimentoProdutoDTO produtoDto : atendimentoDTO.getAtendimentoProdutos()) {
            Produto produto = produtoService.getProdutoById(produtoDto.getProdutoId());
            AtendimentoProduto atendimentoProduto = new AtendimentoProduto(atendimento, produto, produtoDto.getQuantidade());
            atendimentoProduto = atendimentoProdutoRepository.save(atendimentoProduto);
            total = total.add(produto.getValor().multiply(new BigDecimal(atendimentoProduto.getQuantidade())));
        }

        for (AtendimentoServicoDTO servicoDto : atendimentoDTO.getAtendimentoServicos()) {
            Servico servico = servicoService.getServicoById(servicoDto.getServicoId());
            AtendimentoServico atendimentoServico = new AtendimentoServico(atendimento, servico, servicoDto.getQuantidade());
            atendimentoServico = atendimentoServicoRepository.save(atendimentoServico);
            total = total.add(servico.getValor().multiply(new BigDecimal(atendimentoServico.getQuantidade())));
        }
        atendimento.setTotal(total);
        return atendimentoRepository.save(atendimento);
    }

    @Transactional
    public Atendimento updateAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = getAtendimentoById(id);

        if (atendimentoDTO.getVeterinarioId() != null) {
            User veterinario = userRepository.findById(atendimentoDTO.getVeterinarioId())
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: "));
            atendimento.setVeterinario(veterinario);
        }

        atendimento.setDateTime(LocalDateTime.now());
        atendimento = atendimentoRepository.save(atendimento);

        atendimentoProdutoRepository.deleteByAtendimentoId(id);
        atendimentoServicoRepository.deleteByAtendimentoId(id);

        BigDecimal total = BigDecimal.ZERO;

        for (AtendimentoProdutoDTO produtoDto : atendimentoDTO.getAtendimentoProdutos()) {
            Produto produto = produtoService.getProdutoById(produtoDto.getProdutoId());
            AtendimentoProduto atendimentoProduto = new AtendimentoProduto(atendimento, produto, produtoDto.getQuantidade());
            atendimentoProduto = atendimentoProdutoRepository.save(atendimentoProduto);
            total = total.add(produto.getValor().multiply(new BigDecimal(atendimentoProduto.getQuantidade())));
        }

        for (AtendimentoServicoDTO servicoDto : atendimentoDTO.getAtendimentoServicos()) {
            Servico servico = servicoService.getServicoById(servicoDto.getServicoId());
            AtendimentoServico atendimentoServico = new AtendimentoServico(atendimento, servico, servicoDto.getQuantidade());
            atendimentoServico = atendimentoServicoRepository.save(atendimentoServico);
            total = total.add(servico.getValor().multiply(new BigDecimal(atendimentoServico.getQuantidade())));
        }
        atendimento.setTotal(total);
        return atendimentoRepository.save(atendimento);
    }


    public Page<Atendimento> getAllAtendimentos(Pageable pageable) {
        return atendimentoRepository.findAll(pageable);
    }

    public Atendimento getAtendimentoById(Long id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    public void deleteAtendimento(Long id) {
        atendimentoRepository.delete(getAtendimentoById(id));
    }
}
