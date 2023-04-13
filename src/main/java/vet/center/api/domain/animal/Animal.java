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

    private Sexo sexo;

    private String peso;

    private String idade;

    private String cor;

    private Temperamento temperamento;

    private Boolean castrado;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private ProprietarioJPA proprietario;


    public Animal(DadosAnimal dados, ProprietarioJPA proprietario) {
        this.nome = dados.nome();
        this.especie = dados.especie();
        this.raca = dados.raca();
        this.proprietario = proprietario;
        this.sexo = dados.sexo();
        this.peso = dados.peso();
        this.idade = dados.idade();
        this.cor = dados.cor();
        this.temperamento = dados.temperamento();
        this.castrado = dados.castrado();

    }

    public void atualizar(AtualizarAnimal dados) {

        if (dados.peso() != null) {
            this.peso = dados.peso();
        }
        if (dados.idade() != null) {
            this.idade = dados.idade();
        }
        if (dados.castrado() != null) {
            this.castrado = dados.castrado();
        }

    }
}
