package vet.center.api.atendimento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.veterinario.Veterinario;

import java.util.ArrayList;
import java.util.List;

@Table(name = "atendimentos")
@Entity(name = "Atendimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;




}
