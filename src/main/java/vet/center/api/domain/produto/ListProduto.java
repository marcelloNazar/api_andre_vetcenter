package vet.center.api.domain.produto;

public record ListProduto(
        Long id,
      String nome,
      String valor,
      Integer estoque) {

    public ListProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getValor(), produto.getEstoque());
    }
}
