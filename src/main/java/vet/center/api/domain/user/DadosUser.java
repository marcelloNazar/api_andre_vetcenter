package vet.center.api.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DadosUser(

        @NotBlank
        String login,

        @NotBlank
        String password

) {
}
