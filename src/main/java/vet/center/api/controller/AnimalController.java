package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.animal.AnimalRepository;
import vet.center.api.domain.animal.DadosAnimal;
import vet.center.api.domain.proprietario.ProprietarioJPA;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.infra.exception.DataResourceNotFoundException;

@RestController
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;
    @Autowired
    private ProprietarioRepository proprietarioRepository;

    @PostMapping("/{proprietarioId}")
    public void cadastrar(@RequestBody DadosAnimal dados, @PathVariable Long proprietarioId) {

        ProprietarioJPA proprietario = proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new DataResourceNotFoundException("Proprietario não encontrado com ID: " + proprietarioId));


        repository.save(new Animal(dados, proprietario));

    }


}
