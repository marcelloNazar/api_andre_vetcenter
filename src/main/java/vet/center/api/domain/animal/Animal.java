package vet.center.api.domain.animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.domain.proprietario.ProprietarioJPA;

@Table(name = "animal")
@Entity(name = "Animal")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    private String raca;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private ProprietarioJPA proprietario;


    public Animal(DadosAnimal dados, ProprietarioJPA proprietario) {
        this.nome = dados.nome();
        this.especie = dados.especie();
        this.raca = dados.raca();
        this.proprietario = proprietario;
    }
}
