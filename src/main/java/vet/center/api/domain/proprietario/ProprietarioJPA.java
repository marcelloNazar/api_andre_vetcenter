package vet.center.api.domain.proprietario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.endereco.Endereco;

import java.util.List;

@Table(name = "proprietarios")
@Entity(name = "Proprietario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProprietarioJPA {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Animal> animais;


    public ProprietarioJPA(DadosProprietarios dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }
}
