package vet.center.api.domain.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosProduto(
        @NotBlank
        String nome,
        @NotBlank
        String valor,
        @NotNull
        Integer estoque) {
}
