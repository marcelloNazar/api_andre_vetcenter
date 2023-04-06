package vet.center.api.domain.veterinario;

import vet.center.api.domain.endereco.Endereco;

public record DadosDetalhadosVeterinario(Long id, String nome, String email, String crv, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhadosVeterinario(Veterinario veterinario) {
        this(veterinario.getId(), veterinario.getNome(), veterinario.getEmail(), veterinario.getCrv(), veterinario.getEspecialidade(), veterinario.getEndereco());

    }
}
