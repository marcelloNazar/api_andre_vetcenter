package vet.center.api.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosConsulta(
        Long idVeterinario,
        Long idAnimal,
        Long idProduto,

        @NotNull
        @Future
        LocalDateTime data) {



}
