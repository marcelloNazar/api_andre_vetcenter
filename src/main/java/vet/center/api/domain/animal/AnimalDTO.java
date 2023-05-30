package vet.center.api.domain.animal;


import lombok.Data;

@Data
public class AnimalDTO {
    private String nome;
    private Especie especie;
    private String raca;
    private Sexo sexo;
    private String peso;
    private String idade;
    private String cor;
    private Temperamento temperamento;
    private Boolean castrado;
    private Long proprietarioId;
}
