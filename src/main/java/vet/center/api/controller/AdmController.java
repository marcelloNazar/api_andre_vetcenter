package vet.center.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vet.center.api.atendimento.*;
import vet.center.api.config.AuthService;
import vet.center.api.user.User;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/adm/atendimento")
@SecurityRequirement(name = "bearer-key")
@PreAuthorize("hasRole('ADMIN')")
public class AdmController {

    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private AuthService authService;

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
        return ResponseEntity.ok(atendimentoService.getAllAtendimentosAdm(pageable));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Atendimento> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoAdmDTO atendimentoDTO) {
        return ResponseEntity.ok(atendimentoService.updateAtendimentoAdm(id, atendimentoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtendimento(@PathVariable Long id) {
        atendimentoService.deleteAtendimento(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/veterinario")
    public ResponseEntity<Page<User>> getAllVeterinarios(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return ResponseEntity.ok(authService.getAllVeterinarios(pageable));
    }
}
