package vet.center.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vet.center.api.consulta.Agendamento;
import vet.center.api.consulta.DadosConsulta;
import vet.center.api.consulta.DadosDetalhados;

@RestController
@RequestMapping("consultas")
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
