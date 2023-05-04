package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.veterinario.DadosListagemVetrinario;
import vet.center.api.domain.veterinario.Veterinario;
import vet.center.api.domain.veterinario.VeterinarioRepository;
import vet.center.api.domain.veterinario.*;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosVeterinario dados, UriComponentsBuilder uriBuilder) {
        var veterinario = new Veterinario(dados);
        repository.save(veterinario);

        var uri = uriBuilder.path("/veterinario/{id}").buildAndExpand(veterinario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosVeterinario(veterinario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemVetrinario>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemVetrinario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarVeterinario dados) {
        var veterinario = repository.getReferenceById(dados.id());
        veterinario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhadosVeterinario(veterinario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable long id) {
        var veterinario = repository.getReferenceById(id);
        veterinario.excluir();

        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/{um_id}")
    public ResponseEntity detalhar(@PathVariable long id) {
        var veterinario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadosVeterinario(veterinario));
    }

}
