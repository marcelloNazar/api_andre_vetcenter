package vet.center.api.domain.anamnese;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.domain.animal.Especie;
import vet.center.api.domain.animal.Sexo;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalAnamnese {

    @Column(name = "animal_name")
    private String nome;
    private String idade;
    private String raca;
    private Sexo sexo;
    private String peso;
    private Especie especie;

    public AnimalAnamnese(DadosAnamneseAnimal dados) {

        this.nome = dados.nome();
        this.idade = dados.idade();
        this.raca = dados.raca();
        this.sexo = dados.sexo();
        this.peso = dados.peso();
        this.especie = dados.especie();

    }
}
