package vet.center.api.estetica;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.animal.AnimalService;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.produto.ProdutoService;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.servico.ServicoRepository;
import vet.center.api.domain.servico.ServicoService;
import vet.center.api.domain.veterinario.VeterinarioRepository;
import vet.center.api.domain.veterinario.VeterinarioService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EsteticaService {
    @Autowired
    private EsteticaRepository esteticaRepository;
    @Autowired
    private VeterinarioService veterinarioService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ServicoService servicoService;


    public Estetica createEstetica(EsteticaDTO esteticaDTO) {
        Estetica estetica = new Estetica();

        estetica.setVeterinario(veterinarioService.getVeterinarioById(esteticaDTO.getVeterinarioId()));
        estetica.setAnimal(animalService.getAnimalById(esteticaDTO.getAnimalId()));

        BigDecimal totalProdutos = BigDecimal.ZERO;
        if (esteticaDTO.getProdutosIds() != null) {
            List<Produto> produtos = produtoService.getProdutosByIds(esteticaDTO.getProdutosIds());
            estetica.setProdutos(produtos);
            totalProdutos = produtos.stream()
                    .filter(p -> p.getValor() != null)
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal totalServicos = BigDecimal.ZERO;
        if (esteticaDTO.getServicosIds() != null) {
            List<Servico> servicos = servicoService.getServicosByIds(esteticaDTO.getServicosIds());
            estetica.setServicos(servicos);
            totalServicos = servicos.stream()
                    .filter(s -> s.getValor() != null)
                    .map(Servico::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal total = totalProdutos.add(totalServicos);
        estetica.setTotal(total);

        BeanUtils.copyProperties(esteticaDTO, estetica, "veterinarioId", "animalId", "produtosIds", "servicosIds");

        return esteticaRepository.save(estetica);
    }

    public Estetica updateEstetica(Long id, EsteticaDTO esteticaDTO) {
        Estetica estetica = getEsteticaById(id);
        estetica.setVeterinario(veterinarioService.getVeterinarioById(esteticaDTO.getVeterinarioId()));
        estetica.setAnimal(animalService.getAnimalById(esteticaDTO.getAnimalId()));

        BigDecimal totalProdutos = BigDecimal.ZERO;
        if (esteticaDTO.getProdutosIds() != null) {
            List<Produto> produtos = produtoService.getProdutosByIds(esteticaDTO.getProdutosIds());
            estetica.setProdutos(produtos);
            totalProdutos = produtos.stream()
                    .filter(p -> p.getValor() != null)
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal totalServicos = BigDecimal.ZERO;
        if (esteticaDTO.getServicosIds() != null) {
            List<Servico> servicos = servicoService.getServicosByIds(esteticaDTO.getServicosIds());
            estetica.setServicos(servicos);
            totalServicos = servicos.stream()
                    .filter(s -> s.getValor() != null)
                    .map(Servico::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        BigDecimal total = totalProdutos.add(totalServicos);
        estetica.setTotal(total);

        BeanUtils.copyProperties(esteticaDTO, estetica, "veterinarioId", "animalId", "produtosIds", "servicosIds");


        return esteticaRepository.save(estetica);
    }

    public Page<Estetica> getAllEstetica(Pageable pageable) {
        return esteticaRepository.findAll(pageable);
    }

    public Estetica getEsteticaById(Long id) {
        return esteticaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Serviço de estetica não encontrado"));
    }

    public void deleteEstetica(Long id) {esteticaRepository.delete(getEsteticaById(id));}
}
