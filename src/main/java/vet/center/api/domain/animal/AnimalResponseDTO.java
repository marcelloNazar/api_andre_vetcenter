package vet.center.api.domain.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.proprietario.ProprietarioResponseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalResponseDTO {
    private Long id;
    private String nome;
    private Especie especie;
    private String raca;
    private Sexo sexo;
    private String peso;
    private String idade;
    private String cor;
    private Temperamento temperamento;
    private Boolean castrado;
    private Proprietario proprietario;
}
