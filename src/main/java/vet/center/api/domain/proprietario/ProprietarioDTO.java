package vet.center.api.domain.proprietario;


import lombok.Data;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.endereco.Endereco;

import java.util.List;

@Data
public class ProprietarioDTO {
    private String nome;

    private String telefone;

    private String cpf;

    private String nascimento;

    private String sexo;

    private String nome_mae;

    private Endereco endereco;

    private List<Animal> animais;
}
