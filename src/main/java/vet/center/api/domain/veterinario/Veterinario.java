package vet.center.api.domain.veterinario;

import jakarta.persistence.*;
import lombok.*;
import vet.center.api.domain.endereco.Endereco;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "veterinarios")
@Entity(name = "Veterinario")
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crv;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;


}
