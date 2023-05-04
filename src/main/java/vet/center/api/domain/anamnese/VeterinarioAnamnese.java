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
public class VeterinarioAnamnese {

    @Column(name = "veterinario_name")
    private String nome;
    private String crv;

    public VeterinarioAnamnese(DadosAnamneseVeterinario dados) {

        this.nome = dados.nome();
        this.crv = dados.crv();

    }
}
