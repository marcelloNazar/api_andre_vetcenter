package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.animal.DadosDetalhadosAnimal;
import vet.center.api.domain.produto.*;
import vet.center.api.domain.proprietario.DadosDetalhadosProprietario;


import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosProduto dados, UriComponentsBuilder uriBuilder) {

        var produto = new Produto(dados);
        repository.save(produto);

        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosProduto(produto));
    }

    @GetMapping
    public ResponseEntity<Page<ListProduto>> listar(Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(ListProduto::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarProduto dados) {

        var produto = repository.getReferenceById(dados.id());

        produto.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));

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

        var produto = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhadosProduto(produto));

    }




}
