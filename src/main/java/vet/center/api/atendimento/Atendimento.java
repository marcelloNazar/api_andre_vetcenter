package vet.center.api.atendimento;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.produto.AtendimentoProduto;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.servico.AtendimentoServico;
import vet.center.api.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "atendimentos")
@Entity(name = "Atendimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "veterinario_id", nullable = false)
    @JsonManagedReference
    private User veterinario;
    @ManyToOne
    @JoinColumn(name = "proprietario_id", nullable = false)
    @JsonManagedReference
    private Proprietario proprietario;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonManagedReference
    private Animal animal;
    @OneToMany(mappedBy = "atendimento")
    @JsonManagedReference
    private List<AtendimentoProduto> atendimentoProdutos = new ArrayList<>();
    @OneToMany(mappedBy = "atendimento")
    @JsonManagedReference
    private List<AtendimentoServico> atendimentoServicos = new ArrayList<>();
    private LocalDateTime dateTime;
    private Boolean concluido;
    private Boolean pago;
    private Boolean finalizado;
    private BigDecimal total;

}
