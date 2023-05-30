package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.animal.*;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioRepository;
import vet.center.api.infra.exception.DataResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<Page<Animal>> getAllAnimals(Pageable pageable) {
        return ResponseEntity.ok().body(animalService.getAllAnimals(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(animalService.getAnimalById(id));
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@Valid @RequestBody AnimalDTO animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.createAnimal(animal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable(value = "id") Long id, @RequestBody AnimalDTO animalDetails) {
        return ResponseEntity.ok().body(animalService.updateAnimal(id, animalDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable(value = "id") Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/proprietario/{proprietarioId}")
    public List<Animal> getAnimalsByProprietarioId(@PathVariable(value = "proprietarioId") Long proprietarioId) {
        return animalService.getAnimalsByProprietarioId(proprietarioId);
    }
}
