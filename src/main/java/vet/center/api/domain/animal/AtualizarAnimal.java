package vet.center.api.domain.animal;

import jakarta.validation.constraints.NotNull;

public record AtualizarAnimal(
        @NotNull
        Long id,
        String peso,
        String idade,
        Boolean castrado) {
}
