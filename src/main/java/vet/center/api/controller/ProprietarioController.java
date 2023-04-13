package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.animal.AtualizarAnimal;
import vet.center.api.domain.animal.ListAnimal;
import vet.center.api.domain.proprietario.*;

import java.util.List;

@RestController
@RequestMapping("proprietario")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosProprietarios dados) {
        repository.save(new ProprietarioJPA(dados));
    }

    @GetMapping
    public Page<ListProprietario> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(ListProprietario::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarProprietario dados) {

        var proprietario = repository.getReferenceById(dados.id());

        proprietario.atualizar(dados);

    }


}
