package vet.center.api.domain.proprietario;


public record ListProprietario(
        Long id,
        String nome,
        String telefone,
        String cpf,
        String nascimento,
        String sexo,
        String nomeMae) {

    public ListProprietario(ProprietarioJPA proprietario) {
        this(proprietario.getId(), proprietario.getNome(), proprietario.getTelefone(), proprietario.getCpf(), proprietario.getNascimento(), proprietario.getSexo(), proprietario.getNome_mae());
    }


}
