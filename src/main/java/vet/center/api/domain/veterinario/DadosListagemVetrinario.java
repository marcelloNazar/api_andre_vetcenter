package vet.center.api.domain.veterinario;

public record DadosListagemVetrinario(Long id, String nome, String crv, Especialidade especialidade) {

    public DadosListagemVetrinario(Veterinario veterinario) {
        this(veterinario.getId(), veterinario.getNome(), veterinario.getCrv(), veterinario.getEspecialidade());
    }
}
