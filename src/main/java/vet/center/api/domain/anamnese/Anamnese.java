package vet.center.api.domain.anamnese;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.servico.Servico;
import vet.center.api.domain.veterinario.Veterinario;

import java.time.LocalDateTime;

@Table(name = "anamnese")
@Entity(name = "anamnese")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Anamnese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private ProprietarioAnamnese proprietario;

    @Embedded
    private AnimalAnamnese animal;

    @Embedded
    private VeterinarioAnamnese veterinario;
    private String anamnese;
    private String estado;
    private String mucosas;
    private String linfonodos;
    private String tpc;
    private String turgorCutaneo;
    private String desidratacao;
    private boolean ectoparasitas;
    private boolean mioclonias;
    private String prurido;
    private boolean vomito;
    private boolean diarreia;
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
    private boolean cansaco;
    private boolean tosse;
    private String pulso;
    private String fc;
    private String fr;
    private String observacoes2;
    private String examesComplementares;
    private String diagnostico;
    private String prognostico;
    private String tratamento;
    private String retorno;

    @ManyToOne
    private Long veterinarioId;

    @ManyToOne
    private Long animalId;

    @ManyToOne
    private Long proprietarioId;

    private LocalDateTime data;


    public Anamnese(DadosAnamnese dados) {

        this.proprietario = new ProprietarioAnamnese(dados.proprietario());
        this.animal = new AnimalAnamnese(dados.animal());
        this.veterinario = new VeterinarioAnamnese(dados.veterinario());
        this.anamnese = dados.anamnese();
        this.estado = dados.estado();
        this.mucosas = dados.mucosas();
        this.linfonodos = dados.linfonodos();
        this.tpc = dados.tpc();
        this.turgorCutaneo = dados.turgorCutaneo();
        this.desidratacao = dados.desidratacao();
        this.ectoparasitas = dados.ectoparasitas();
        this.mioclonias = dados.mioclonias();
        this.prurido = dados.prurido();
        this.vomito = dados.vomito();
        this.diarreia = dados.diarreia();
        this.inapatencia = dados.inapatencia();
        this.secrecoesPatologicas = dados.secrecoesPatologicas();
        this.calculoDentario = dados.calculoDentario();
        this.auscultacaoPulmonar = dados.auscultacaoPulmonar();
        this.auscultacaoCardiaca = dados.auscultacaoCardiaca();
        this.reflexoToce = dados.reflexoToce();
        this.emagrecimento = dados.emagrecimento();
        this.alteracaoComportamental = dados.alteracaoComportamental();
        this.observacoes = dados.observacoes();
        this.extoscopia = dados.extoscopia();
        this.cavidadeAbdominal = dados.cavidadeAbdominal();
        this.cabecaPescoco = dados.cabecaPescoco();
        this.sistemaNervoso = dados.sistemaNervoso();
        this.sistemaLocomotor = dados.sistemaLocomotor();
        this.cansaco = dados.cansaco();
        this.tosse = dados.tosse();
        this.pulso = dados.pulso();
        this.fc = dados.fc();
        this.fr = dados.fr();
        this.observacoes2 = dados.observacoes2();
        this.examesComplementares = dados.examesComplementares();
        this.diagnostico = dados.diagnostico();
        this.prognostico = dados.prognostico();
        this.tratamento = dados.tratamento();
        this.retorno = dados.retorno();
        this.veterinarioId = dados.veterinarioId();
        this.animalId = dados.animalId();
        this.proprietarioId = dados.proprietarioId();
        this.data = dados.data();
    }
}
