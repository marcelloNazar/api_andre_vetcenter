package vet.center.api.domain.animal;

import vet.center.api.domain.proprietario.ProprietarioJPA;

public record DadosAnimal(String nome, String raca, Especie especie, ProprietarioJPA proprietario) {
}
