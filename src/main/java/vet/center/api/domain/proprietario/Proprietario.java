package vet.center.api.domain.proprietario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.endereco.Endereco;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proprietarios")
public class Proprietario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String cpf;

    private String nascimento;

    private String sexo;

    private String nomeMae;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    @JsonIgnore
    @JsonBackReference
    private List<Animal> animais;

}
