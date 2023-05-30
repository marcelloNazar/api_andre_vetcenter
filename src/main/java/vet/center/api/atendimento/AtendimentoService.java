package vet.center.api.atendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.produto.ProdutoRepository;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.servico.ServicoRepository;
import vet.center.api.domain.veterinario.VeterinarioRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    public Atendimento createAtendimento(AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = new Atendimento();
        atendimento.setVeterinario(veterinarioRepository.findById(atendimentoDTO.getVeterinarioId()).orElseThrow(() -> new RuntimeException("Veterinario not found")));
        atendimento.setProprietario(proprietarioRepository.findById(atendimentoDTO.getProprietarioId()).orElseThrow(() -> new RuntimeException("Proprietario not found")));
        atendimento.setAnimal(animalRepository.findById(atendimentoDTO.getAnimalId()).orElseThrow(() -> new RuntimeException("Animal not found")));
        atendimentoDTO.getProdutosIds().forEach(id -> atendimento.getProdutos().add(produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto not found"))));
        atendimentoDTO.getServicosIds().forEach(id -> atendimento.getServicos().add(servicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico not found"))));
        atendimento.setDateTime(LocalDateTime.now());
        BigDecimal total = atendimento.getProdutos().stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        total = total.add(atendimento.getServicos().stream().map(Servico::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        atendimento.setTotal(total);
        return atendimentoRepository.save(atendimento);
    }

    public Page<Atendimento> getAllAtendimentos(Pageable pageable) {
        return atendimentoRepository.findAll(pageable);
    }

    public Atendimento getAtendimento(Long id) {
        return atendimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendimento not found"));
    }

    public Atendimento updateAtendimento(Long id, AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = getAtendimento(id);
        atendimento.setVeterinario(veterinarioRepository.findById(atendimentoDTO.getVeterinarioId()).orElseThrow(() -> new RuntimeException("Veterinario not found")));
        atendimento.setProprietario(proprietarioRepository.findById(atendimentoDTO.getProprietarioId()).orElseThrow(() -> new RuntimeException("Proprietario not found")));
        atendimento.setAnimal(animalRepository.findById(atendimentoDTO.getAnimalId()).orElseThrow(() -> new RuntimeException("Animal not found")));
        atendimento.getProdutos().clear();
        atendimento.getServicos().clear();
        atendimentoDTO.getProdutosIds().forEach(idP -> atendimento.getProdutos().add(produtoRepository.findById(idP).orElseThrow(() -> new RuntimeException("Produto not found"))));
        atendimentoDTO.getServicosIds().forEach(idS -> atendimento.getServicos().add(servicoRepository.findById(idS).orElseThrow(() -> new RuntimeException("Servico not found"))));
        atendimento.setDateTime(LocalDateTime.now());
        BigDecimal total = atendimento.getProdutos().stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        total = total.add(atendimento.getServicos().stream().map(Servico::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        atendimento.setTotal(total);
        return atendimentoRepository.save(atendimento);
    }

    public void deleteAtendimento(Long id) {
        Atendimento atendimento = getAtendimento(id);
        atendimentoRepository.delete(atendimento);
    }
}
