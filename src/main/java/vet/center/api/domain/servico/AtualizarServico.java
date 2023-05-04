package vet.center.api.domain.servico;

import jakarta.validation.constraints.NotNull;

public record AtualizarServico(

        @NotNull
        Long id,

        String valor,

        String descricao
) {
}
