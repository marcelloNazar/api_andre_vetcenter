package vet.center.api.anamnese;

import jakarta.persistence.*;
import lombok.*;
import vet.center.api.atendimento.Atendimento;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.veterinario.Veterinario;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "anamnese")
@Entity(name = "anamnese")
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "atendimento_id", nullable = false)
    private Atendimento atendimento;

    private String anamnese;
    private String estado;
    private String mucosas;
    private String linfonodos;
    private String tpc;
    private String turgorCutaneo;
    private String desidratacao;
    private Boolean ectoparasitas;
    private Boolean mioclonias;
    private String prurido;
    private Boolean vomito;
    private Boolean diarreia;
    private String inapatencia;
    private String secrecoesPatologicas;
    private String calculoDentario;
    private String auscultacaoPulmonar;
    private String auscultacaoCardiaca;
    private String reflexoToce;
    private String emagrecimento;
    private String alteracaoComportamental;
    private String observacoes;
    private String extoscopia;
    private String cavidadeAbdominal;
    private String cabecaPescoco;
    private String sistemaNervoso;
    private String sistemaLocomotor;
    private Boolean cansaco;
    private Boolean tosse;
    private String pulso;
    private String fc;
    private String fr;
    private String observacoes2;
    private String examesComplementares;
    private String diagnostico;
    private String prognostico;
    private String tratamento;
    private String retorno;
    private LocalDateTime data;

}
