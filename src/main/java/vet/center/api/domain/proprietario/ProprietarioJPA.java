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

    private String cpf;

    private String nascimento;

    private String sexo;

    private String nome_mae;

    private Boolean ativo;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "proprietario", cascade = CascadeType.ALL)
    private List<Animal> animais;


    public ProprietarioJPA(DadosProprietarios dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.nascimento = dados.nascimento();
        this.sexo = dados.sexo();
        this.nome_mae = dados.nomeMae();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizar(AtualizarProprietario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
