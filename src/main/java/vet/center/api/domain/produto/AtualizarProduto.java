package vet.center.api.domain.produto;

import jakarta.validation.constraints.NotNull;

public record AtualizarProduto(

        @NotNull
        Long id,

        String valor

) {
}
