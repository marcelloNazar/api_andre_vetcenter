package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.servico.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosServico dados, UriComponentsBuilder uriBuilder) {

        var servico = new Servico(dados);
        repository.save(servico);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(servico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosServicos(servico));
    }

    @GetMapping
    public ResponseEntity<Page<ListServicos>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListServicos::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarServico dados) {

        var servico = repository.getReferenceById(dados.id());

        servico.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosServicos(servico));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        var produto = repository.getReferenceById(id);

        produto.excluir();

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {

        var servico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadosServicos(servico));

    }




}
