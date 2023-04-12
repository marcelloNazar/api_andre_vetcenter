package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.center.api.domain.proprietario.DadosProprietarios;
import vet.center.api.domain.proprietario.ProprietarioJPA;
import vet.center.api.domain.proprietario.ProprietarioRepository;

@RestController
@RequestMapping("proprietario")
public class ProprietarioController {

    @Autowired
    private ProprietarioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosProprietarios dados) {
        repository.save(new ProprietarioJPA(dados));
    }

}
