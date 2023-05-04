package vet.center.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vet.center.api.consulta.Agendamento;
import vet.center.api.consulta.DadosConsulta;
import vet.center.api.domain.animal.ListAnimal;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private Agendamento agenda;


    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosConsulta dados) {

        var dto = agenda.agendar(dados);

        return ResponseEntity.ok(dto);

    }
}
