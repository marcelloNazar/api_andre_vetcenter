package vet.center.api.atendimento;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AtendimentoMapper {

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

    public AtendimentoDTO toDto(Atendimento atendimento) {
        AtendimentoDTO dto = new AtendimentoDTO();
        dto.setId(atendimento.getId());
        dto.setVeterinarioId(atendimento.getVeterinario().getId());
        dto.setProprietarioId(atendimento.getProprietario().getId());
        dto.setAnimalId(atendimento.getAnimal().getId());
        List<Long> produtosIds = atendimento.getProdutos().stream()
                .map(Produto::getId)
                .collect(Collectors.toList());
        dto.setProdutosIds(produtosIds);

        List<Long> servicosIds = atendimento.getServicos().stream()
                .map(Servico::getId)
                .collect(Collectors.toList());
        dto.setServicosIds(servicosIds);

        return dto;
    }

    public Atendimento toEntity(AtendimentoDTO dto) {
        Atendimento atendimento = new Atendimento();
        return updateEntity(atendimento, dto);
    }

    public Atendimento updateEntity(Atendimento atendimento, AtendimentoDTO dto) {
        Veterinario veterinario = veterinarioRepository.findById(dto.getVeterinarioId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinario não encontrado"));
        Proprietario proprietario = proprietarioRepository.findById(dto.getProprietarioId())
                .orElseThrow(() -> new EntityNotFoundException("Proprietario não encontrado"));
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new EntityNotFoundException("Animal não encontrado"));

        atendimento.setVeterinario(veterinario);
        atendimento.setProprietario(proprietario);
        atendimento.setAnimal(animal);

        List<Produto> produtos = produtoRepository.findAllById(dto.getProdutosIds());
        if (produtos.size() != dto.getProdutosIds().size()) {
            throw new EntityNotFoundException("Algum(ns) produto(s) não encontrado(s)");
        }
        atendimento.setProdutos(produtos);

        List<Servico> servicos = servicoRepository.findAllById(dto.getServicosIds());
        if (servicos.size() != dto.getServicosIds().size()) {
            throw new EntityNotFoundException("Algum(ns) serviço(s) não encontrado(s)");
        }
        atendimento.setServicos(servicos);

        return atendimento;
    }
    public AtendimentoResponse toResponseDto(Atendimento atendimento) {
        AtendimentoResponse dto = new AtendimentoResponse();
        dto.setId(atendimento.getId());
        dto.setVeterinarioId(atendimento.getVeterinario().getId());
        dto.setVeterinarioNome(atendimento.getVeterinario().getNome());
        dto.setProprietarioId(atendimento.getProprietario().getId());
        dto.setProprietarioNome(atendimento.getProprietario().getNome());
        dto.setAnimalId(atendimento.getAnimal().getId());

        List<Long> produtosIds = atendimento.getProdutos().stream()
                .map(Produto::getId)
                .collect(Collectors.toList());
        dto.setProdutosIds(produtosIds);

        List<Long> servicosIds = atendimento.getServicos().stream()
                .map(Servico::getId)
                .collect(Collectors.toList());
        dto.setServicosIds(servicosIds);

        return dto;
    }

}
