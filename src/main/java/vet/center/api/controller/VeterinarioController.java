package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.veterinario.Veterinario;
import vet.center.api.domain.veterinario.*;

import java.util.List;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public ResponseEntity<List<Veterinario>> getAllVeterinarios() {
        return ResponseEntity.ok(veterinarioService.getAllVeterinarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(veterinarioService.getVeterinarioById(id));
    }

    @PostMapping
    public ResponseEntity<Veterinario> createVeterinario(@RequestBody Veterinario veterinario) {
        return new ResponseEntity<>(veterinarioService.createVeterinario(veterinario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable(value = "id") Long id, @RequestBody Veterinario veterinarioDetails) {
        return ResponseEntity.ok(veterinarioService.updateVeterinario(id, veterinarioDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable(value = "id") Long id) {
        veterinarioService.deleteVeterinario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
