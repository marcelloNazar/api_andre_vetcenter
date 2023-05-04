package vet.center.api.domain.proprietario;

import vet.center.api.domain.endereco.Endereco;

public record DadosDetalhadosProprietario(Long id, String nome, String telefone, String cpf, String nascimento, String sexo, String nomeMae, Endereco endereco) {

    public DadosDetalhadosProprietario(Proprietario proprietario) {
        this(proprietario.getId(), proprietario.getNome(), proprietario.getTelefone(), proprietario.getCpf(), proprietario.getNascimento(), proprietario.getSexo(), proprietario.getNome_mae(), proprietario.getEndereco());
    }

}
