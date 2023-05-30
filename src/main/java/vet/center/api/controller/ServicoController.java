package vet.center.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vet.center.api.domain.servico.*;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<Page<Servico>> getAllServicos(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return ResponseEntity.ok(servicoService.getAllServicos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getServicoById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(servicoService.getServicoById(id));
    }

    @PostMapping
    public ResponseEntity<Servico> createServico(@RequestBody Servico servico) {
        return new ResponseEntity<>(servicoService.createServico(servico), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable(value = "id") Long id, @RequestBody Servico servicoDetails) {
        return ResponseEntity.ok(servicoService.updateServico(id, servicoDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable(value = "id") Long id) {
        servicoService.deleteServico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
