package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.produto.*;


import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosProduto dados) {
        repository.save(new Produto(dados));
    }

    @GetMapping
    public Page<ListProduto> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListProduto::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarProduto dados) {

        var produto = repository.getReferenceById(dados.id());

        produto.atualizar(dados);

    }



}
