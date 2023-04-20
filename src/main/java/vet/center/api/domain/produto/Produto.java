package vet.center.api.domain.produto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String valor;
    private Integer estoque;

    private Boolean ativo;

    public Produto(DadosProduto dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.estoque = dados.estoque();
        this.ativo = true;
    }

    public void atualizar(AtualizarProduto dados) {
        this.valor = dados.valor();
    }

    public void excluir() {
        this.ativo = false;
    }
}
