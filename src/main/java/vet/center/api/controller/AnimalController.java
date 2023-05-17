package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.animal.*;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.infra.exception.DataResourceNotFoundException;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAnimal dados, UriComponentsBuilder uriBuilder) {

        Proprietario proprietario = proprietarioRepository.findById(dados.proprietario_id())
                .orElseThrow(() -> new DataResourceNotFoundException("Proprietario não encontrado com ID: " + dados.proprietario_id()));

        var animal = new Animal(dados, proprietario);

        repository.save(animal);

        var uri = uriBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosAnimal(animal));

    }
    @GetMapping
    public ResponseEntity<Page<ListAnimal>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListAnimal::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarAnimal dados) {

        var animal = repository.getReferenceById(dados.id());

        animal.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosAnimal(animal));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var animal = repository.getReferenceById(id);

        animal.excluir();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{proprietario_id}")
    public ResponseEntity<Page<ListAnimal>> detalhar(@PathVariable Long proprietario_id, Pageable paginacao) {

        var page = repository.findByProprietarioId(proprietario_id, paginacao).map(ListAnimal::new);

        return ResponseEntity.ok().body(page);

    }



}