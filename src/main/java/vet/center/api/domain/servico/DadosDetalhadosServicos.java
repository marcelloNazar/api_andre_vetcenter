package vet.center.api.domain.servico;

import vet.center.api.domain.produto.Produto;

public record DadosDetalhadosServicos(Long id, String nome, String valor, String descricao) {

    public DadosDetalhadosServicos(Servico servico) {
        this(servico.getId(), servico.getNome(), servico.getValor(), servico.getDescricao());
    }


}
