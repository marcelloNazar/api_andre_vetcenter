package vet.center.api.domain.veterinario;

import jakarta.validation.constraints.NotNull;
import vet.center.api.domain.endereco.DadosEndereco;

public record AtualizarVeterinario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
