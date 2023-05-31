package vet.center.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.center.api.domain.veterinario.Veterinario;
import vet.center.api.domain.veterinario.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @PostMapping
    public ResponseEntity<Veterinario> createVeterinario(@RequestBody Veterinario veterinario) {
        return ResponseEntity.status(CREATED).body(veterinarioService.createVeterinario(veterinario));
    }

    @GetMapping
    public ResponseEntity<Page<Veterinario>> getAllVeterinarios(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(veterinarioService.getAllVeterinarios(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinarioById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(veterinarioService.getVeterinarioById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable(value = "id") Long id, @RequestBody Veterinario veterinarioDetails) {
        return ResponseEntity.ok(veterinarioService.updateVeterinario(id, veterinarioDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeterinario(@PathVariable(value = "id") Long id) {
        veterinarioService.deleteVeterinario(id);
        return ResponseEntity.noContent().build();
    }
}
