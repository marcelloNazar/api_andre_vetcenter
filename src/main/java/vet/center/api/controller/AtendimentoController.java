package vet.center.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private AtendimentoMapper atendimentoMapper;


    @PostMapping
    public ResponseEntity<AtendimentoDTO> createAtendimento(@RequestBody AtendimentoDTO atendimentoDTO) {
        Atendimento atendimento = atendimentoMapper.toEntity(atendimentoDTO);
        Atendimento savedAtendimento = atendimentoRepository.save(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoMapper.toDto(savedAtendimento));
    }

    @GetMapping
    public ResponseEntity<Page<AtendimentoResponse>> getAllAtendimentos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Atendimento> atendimentos = atendimentoRepository.findAll(pageRequest);
        Page<AtendimentoResponse> atendimentoDTOs = atendimentos.map(atendimentoMapper::toResponseDto);

        return ResponseEntity.ok(atendimentoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> getAtendimentoById(@PathVariable Long id) {
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if (atendimento.isPresent()) {
            return ResponseEntity.ok(atendimentoMapper.toDto(atendimento.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoDTO> updateAtendimento(@PathVariable Long id, @RequestBody AtendimentoDTO atendimentoDTO) {
        Optional<Atendimento> atendimentoOpt = atendimentoRepository.findById(id);
        if (atendimentoOpt.isPresent()) {
            Atendimento atendimento = atendimentoOpt.get();
            atendimentoMapper.updateEntity(atendimento, atendimentoDTO);
            Atendimento updatedAtendimento = atendimentoRepository.save(atendimento);
            return ResponseEntity.ok(atendimentoMapper.toDto(updatedAtendimento));
        }
        return ResponseEntity.notFound().build();
    }
}
