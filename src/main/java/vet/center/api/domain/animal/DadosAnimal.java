package vet.center.api.domain.animal;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAnimal(

        @NotBlank
        String nome,
        @NotBlank
        String raca,
        @NotNull
        Especie especie,
        @NotNull
        Sexo sexo,
        @NotBlank
        String peso,
        @NotBlank
        String idade,
        @NotBlank
        String cor,
        @NotNull
        Temperamento temperamento,
        @NotNull
        Boolean castrado,
        @NotNull
        Long proprietario_id
) {


}

