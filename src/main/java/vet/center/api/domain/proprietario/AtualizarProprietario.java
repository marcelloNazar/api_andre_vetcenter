package vet.center.api.domain.proprietario;

import jakarta.validation.constraints.NotNull;
import vet.center.api.domain.endereco.DadosEndereco;

public record AtualizarProprietario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
