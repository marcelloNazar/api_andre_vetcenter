package vet.center.api.atendimento;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.animal.AnimalService;
import vet.center.api.domain.produto.*;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.domain.proprietario.ProprietarioService;
import vet.center.api.domain.servico.*;
import vet.center.api.user.User;
import vet.center.api.user.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    @Autowired
    private ProprietarioService proprietarioService;
    @Autowired
    private ProprietarioRepository proprietarioRepository;
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

        User veterinario = userRepository.findById(atendimentoDTO.getVeterinarioId()).orElseThrow(() -> new UsernameNotFoundException("Veterinario não encontrado: "));
        atendimento.setVeterinario(veterinario);
        Animal animal = animalService.getAnimalById(atendimentoDTO.getAnimalId());

        atendimento.setAnimal(animal);
        atendimento.setProprietario(animal.getProprietario());
        atendimento.setDateTime(LocalDateTime.now());

        return atendimentoRepository.save(atendimento);
    }

    @Transactional
    public Atendimento updateAtendimento(Long id, AtendimentoUpdateDTO atendimentoDTO) {
        Atendimento atendimento = getAtendimentoById(id);

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        if (!atendimento.getVeterinario().getUsername().equals(currentUserName)) {
            throw new RuntimeException("Você não tem permissão para atualizar este atendimento.");
        }

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

        if (atendimentoDTO.getConcluido()) {
            atendimento.setConcluido(true);
        }

        return atendimentoRepository.save(atendimento);
    }

    @Transactional
    public Atendimento updateAtendimentoAdm(Long id, AtendimentoAdmDTO atendimentoDTO) {
        Atendimento atendimento = getAtendimentoById(id);
        atendimento.setPago(false);

        if (atendimentoDTO.getVeterinarioId() != null) {
            User veterinario = userRepository.findById(atendimentoDTO.getVeterinarioId()).orElseThrow(() -> new UsernameNotFoundException("Veterinario não encontrado: "));
            atendimento.setVeterinario(veterinario);
        }
        if (atendimentoDTO.getPago()) {
            atendimento.setPago(true);
        }
        if (!atendimentoDTO.getPago()) {
            Proprietario proprietario = proprietarioService.getProprietarioById(atendimento.getProprietario().getId());
            proprietario.setDivida(atendimento.getTotal());
            proprietarioRepository.save(proprietario);
        }
        return atendimentoRepository.save(atendimento);
    }

    public Page<Atendimento> getAllAtendimentosAdm(Pageable pageable) {
        return atendimentoRepository.findAll(pageable);
    }

    public Page<Atendimento> getAllAtendimentosConcluidos(Pageable pageable) {
        return atendimentoRepository.findAllByConcluidoTrue(pageable);
    }

    public Page<Atendimento> getAllAtendimentosPagos(Pageable pageable) {
        return atendimentoRepository.findAllByPagoTrue(pageable);
    }

    public Page<Atendimento> getAllAtendimentosPagosFalse(Pageable pageable) {
        return atendimentoRepository.findAllByConcluidoFalse(pageable);
    }

    public Page<Atendimento> getAllAtendimentos(Pageable pageable) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User veterinario = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
            Long veterinarioId = veterinario.getId();
            return atendimentoRepository.findAllByVeterinarioId(veterinarioId, pageable);
        } catch (Exception e) {
            return Page.empty();
        }
    }

    public Atendimento getAtendimentoById(Long id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }

    public void deleteAtendimento(Long id) {
        atendimentoRepository.delete(getAtendimentoById(id));
    }
}
