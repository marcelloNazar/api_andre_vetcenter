package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.animal.*;
import vet.center.api.domain.proprietario.ProprietarioJPA;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.infra.exception.DataResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping("/{proprietarioId}")
    public void cadastrar(@RequestBody @Valid DadosAnimal dados, @PathVariable Long proprietarioId) {

        ProprietarioJPA proprietario = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new DataResourceNotFoundException("Proprietario não encontrado com ID: " + proprietarioId));


        repository.save(new Animal(dados, proprietario));

    }
    @GetMapping
    public Page<ListAnimal> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListAnimal::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarAnimal dados) {

        var animal = repository.getReferenceById(dados.id());

        animal.atualizar(dados);

    }

}
