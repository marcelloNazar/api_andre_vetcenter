package vet.center.api.domain.servico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosServico(
        @NotBlank
        String nome,
        @NotBlank
        String valor,
        String descricao
) {
}
