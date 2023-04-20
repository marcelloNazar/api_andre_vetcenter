package vet.center.api.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vet.center.api.consulta.ConsultaRepository;
import vet.center.api.consulta.DadosConsulta;
import vet.center.api.domain.ValidacaoExeption;

@Component
public class VeterinarioEmConsulta implements ValidadorConsultas {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosConsulta dados) {
        var veterinarioEstaEmConsulta = repository.existsByVeterinarioIdAndData(dados.idVeterinario(), dados.data());
        if (veterinarioEstaEmConsulta) {
            throw new ValidacaoExeption("Veterinario esta em atendimento");
        }
    }

}
