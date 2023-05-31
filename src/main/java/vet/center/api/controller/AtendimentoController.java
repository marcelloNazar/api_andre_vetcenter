package vet.center.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.center.api.atendimento.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<Atendimento> createAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
        return ResponseEntity.status(CREATED).body(atendimentoService.createAtendimento(atendimentoDTO));
    }

    @GetMapping
    public ResponseEntity<Page<Atendimento>> getAllAtendimentos(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(atendimentoService.getAllAtendimentos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimento(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.getAtendimentoById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoDTO atendimentoDTO) {
        return ResponseEntity.ok(atendimentoService.updateAtendimento(id, atendimentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
        return ResponseEntity.noContent().build();
    }
}
