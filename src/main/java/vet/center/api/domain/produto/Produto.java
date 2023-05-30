package vet.center.api.domain.produto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import vet.center.api.atendimento.Atendimento;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
@Entity(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private Integer estoque;
    private String descricao;
    @ManyToMany(mappedBy = "produtos")
    @JsonIgnore
    @JsonBackReference
    private Set<Atendimento> atendimentos = new HashSet<>();

}
