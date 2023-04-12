package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.center.api.domain.produto.DadosProduto;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.produto.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosProduto dados) {
        repository.save(new Produto(dados));
    }

}
