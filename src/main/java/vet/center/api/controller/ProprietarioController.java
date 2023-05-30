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
import vet.center.api.domain.proprietario.*;

@RestController
@RequestMapping("/proprietario")
public class ProprietarioController {

    @Autowired
    private ProprietarioService proprietarioService;

    @PostMapping
    public ResponseEntity<Proprietario> cadastrar(@RequestBody Proprietario proprietario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proprietarioService.createProprietario(proprietario));
    }

    @GetMapping
    public ResponseEntity<Page<Proprietario>> listar(Pageable paginacao) {
        return ResponseEntity.ok().body(proprietarioService.getAllProprietarios(paginacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable Long id, @Valid @RequestBody Proprietario proprietario) {
        return ResponseEntity.ok().body(proprietarioService.updateProprietario(id, proprietario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        proprietarioService.deleteProprietario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        return ResponseEntity.ok().body(proprietarioService.getProprietarioById(id));
    }


}
