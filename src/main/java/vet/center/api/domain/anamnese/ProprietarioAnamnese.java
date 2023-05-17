package vet.center.api.domain.anamnese;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class   ProprietarioAnamnese {

    private Long id;
    @Column(name = "proprietario_name")
    private String nome;

    public ProprietarioAnamnese(DadosAnamneseProprietario dados) {
        this.nome = dados.nome();
    }
}
