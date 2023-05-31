package vet.center.api.atendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.animal.AnimalService;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.produto.ProdutoService;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.servico.ServicoRepository;
import vet.center.api.domain.servico.ServicoService;
import vet.center.api.domain.veterinario.VeterinarioRepository;
import vet.center.api.domain.veterinario.VeterinarioService;

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

    public Atendimento createAtendimento(AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = new Atendimento();

        atendimento.setVeterinario(veterinarioService.getVeterinarioById(atendimentoDTO.getVeterinarioId()));
        atendimento.setAnimal(animalService.getAnimalById(atendimentoDTO.getAnimalId()));

        BigDecimal totalProdutos = BigDecimal.ZERO;
        if (atendimentoDTO.getProdutosIds() != null) {
            List<Produto> produtos = produtoService.getProdutosByIds(atendimentoDTO.getProdutosIds());
            atendimento.setProdutos(produtos);
            totalProdutos = produtos.stream()
                    .filter(p -> p.getValor() != null)
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal totalServicos = BigDecimal.ZERO;
        if (atendimentoDTO.getServicosIds() != null) {
            List<Servico> servicos = servicoService.getServicosByIds(atendimentoDTO.getServicosIds());
            atendimento.setServicos(servicos);
            totalServicos = servicos.stream()
                    .filter(s -> s.getValor() != null)
                    .map(Servico::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal total = totalProdutos.add(totalServicos);
        atendimento.setTotal(total);

        atendimento.setDateTime(LocalDateTime.now());

        return atendimentoRepository.save(atendimento);
    }

    public Atendimento updateAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = getAtendimentoById(id);
        atendimento.setVeterinario(veterinarioService.getVeterinarioById(atendimentoDTO.getVeterinarioId()));
        atendimento.setAnimal(animalService.getAnimalById(atendimentoDTO.getAnimalId()));

        BigDecimal totalProdutos = BigDecimal.ZERO;
        if (atendimentoDTO.getProdutosIds() != null) {
            List<Produto> produtos = produtoService.getProdutosByIds(atendimentoDTO.getProdutosIds());
            atendimento.setProdutos(produtos);
            totalProdutos = produtos.stream()
                    .filter(p -> p.getValor() != null)
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal totalServicos = BigDecimal.ZERO;
        if (atendimentoDTO.getServicosIds() != null) {
            List<Servico> servicos = servicoService.getServicosByIds(atendimentoDTO.getServicosIds());
            atendimento.setServicos(servicos);
            totalServicos = servicos.stream()
                    .filter(s -> s.getValor() != null)
                    .map(Servico::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal total = totalProdutos.add(totalServicos);
        atendimento.setTotal(total);

        atendimento.setDateTime(LocalDateTime.now());

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
