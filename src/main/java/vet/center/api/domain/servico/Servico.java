package vet.center.api.domain.servico;

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
@Table(name = "servicos")
@Entity(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal valor;
    private String descricao;
    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    @JsonBackReference
    private Set<Atendimento> atendimentos = new HashSet<>();

}
