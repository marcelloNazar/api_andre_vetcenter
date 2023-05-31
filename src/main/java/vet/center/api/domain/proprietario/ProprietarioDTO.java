package vet.center.api.domain.proprietario;

import lombok.Data;
import vet.center.api.domain.endereco.Endereco;

@Data
public class ProprietarioDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String nascimento;
    private String sexo;
    private String nomeMae;
    private Endereco endereco;
}
