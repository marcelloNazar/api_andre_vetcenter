package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.center.api.domain.anamnese.Anamnese;
import vet.center.api.domain.anamnese.AnamneseRepository;
import vet.center.api.domain.anamnese.DadosAnamnese;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {

    @Autowired
    private AnamneseRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosAnamnese dados) {

        repository.save(new Anamnese(dados));

    }

}
