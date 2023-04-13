package vet.center.api.domain.proprietario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import vet.center.api.domain.endereco.DadosEndereco;

public record DadosProprietarios(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{10,12}")
        String cpf,
        @NotBlank
        String nascimento,
        @NotBlank
        String sexo,
        @NotBlank
        String nomeMae,
        @NotBlank
        @Valid
        DadosEndereco endereco
) {
}
