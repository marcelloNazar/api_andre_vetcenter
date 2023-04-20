package vet.center.api.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vet.center.api.consulta.DadosConsulta;
import vet.center.api.domain.ValidacaoExeption;
import vet.center.api.domain.veterinario.VeterinarioRepository;

@Component
public class VeterinarioAtivo implements ValidadorConsultas {

    @Autowired
    private VeterinarioRepository repository;

    public void validar(DadosConsulta dados) {

        var veterinarioAtivo = repository.findAtivoById(dados.idVeterinario());
        if(!veterinarioAtivo) {
            throw new ValidacaoExeption("O veterinario não esta disponivel");
        }

    }

}
