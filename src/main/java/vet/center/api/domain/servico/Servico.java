package vet.center.api.domain.servico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.atendimento.Atendimento;

import java.util.HashSet;
import java.util.Set;

@Table(name = "servicos")
@Entity(name = "Servico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String valor;

    private String descricao;

    private Boolean ativo;

    @ManyToMany(mappedBy = "servicos")
    private Set<Atendimento> atendimentos = new HashSet<>();




    public Servico(DadosServico dados) {
        this.nome = dados.nome();
        this.valor = dados.valor();
        this.descricao = dados.descricao();
        this.ativo = true;
    }

    public void atualizar(AtualizarServico dados) {
        this.valor = dados.valor();
        this.descricao = dados.descricao();
    }

    public void excluir() {
        this.ativo = false;
    }
}
