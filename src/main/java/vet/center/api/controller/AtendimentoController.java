package vet.center.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vet.center.api.atendimento.*;

import java.util.Optional;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping
    public ResponseEntity<Atendimento> createAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
        return new ResponseEntity<>(atendimentoService.createAtendimento(atendimentoDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Atendimento>> getAllAtendimentos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(atendimentoService.getAllAtendimentos(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> getAtendimento(@PathVariable Long id) {
        return new ResponseEntity<>(atendimentoService.getAtendimento(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoDTO atendimentoDTO) {
        return new ResponseEntity<>(atendimentoService.updateAtendimento(id, atendimentoDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
