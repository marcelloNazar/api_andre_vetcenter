package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.proprietario.*;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosProprietarios dados, UriComponentsBuilder uriBuilder) {

        var proprietario = new Proprietario(dados);
        repository.save(proprietario);

        var uri = uriBuilder.path("/proprietario/{id}").buildAndExpand(proprietario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosProprietario(proprietario));
    }

    @GetMapping
    public ResponseEntity<Page<ListProprietario>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListProprietario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarProprietario dados) {

        var proprietario = repository.getReferenceById(dados.id());

        proprietario.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosProprietario(proprietario));

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var proprietarioJPA = repository.getReferenceById(id);

        proprietarioJPA.excluir();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var proprietario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadosProprietario(proprietario));

    }


}
