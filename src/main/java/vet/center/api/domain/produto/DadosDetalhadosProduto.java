package vet.center.api.domain.produto;

public record DadosDetalhadosProduto(Long id, String nome, String valor, Integer estoque) {

    public DadosDetalhadosProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getEstoque());
    }

}
