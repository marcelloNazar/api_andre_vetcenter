package vet.center.api.domain.servico;

public record ListServicos(
        Long id,
        String nome,
        String valor,
        String descricao) {

    public ListServicos(Servico servico) {
        this(servico.getId(), servico.getNome(), servico.getDescricao(), servico.getValor());
    }
}
