package vet.center.api.domain.anamnese;

import vet.center.api.domain.animal.Especie;
import vet.center.api.domain.animal.Sexo;

public record DadosAnamneseAnimal(String nome, String idade, String raca, Sexo sexo, String peso, Especie especie) {
}
