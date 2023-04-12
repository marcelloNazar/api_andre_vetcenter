package vet.center.api.domain.proprietario;

import vet.center.api.domain.endereco.DadosEndereco;

public record DadosProprietarios(String nome, String telefone, DadosEndereco endereco) {
}
