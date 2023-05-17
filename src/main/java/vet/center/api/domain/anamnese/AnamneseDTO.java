package vet.center.api.domain.anamnese;

import java.time.LocalDateTime;

public class AnamneseDTO {

    private Long id;
    private Long veterinarioId;
    private Long proprietarioId;
    private Long animalId;
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

    public AnamneseDTO(Long id, Long veterinarioId, Long proprietarioId, Long animalId, String anamnese, String estado, String mucosas, String linfonodos, String tpc, String turgorCutaneo, String desidratacao, Boolean ectoparasitas, Boolean mioclonias, String prurido, Boolean vomito, Boolean diarreia, String inapatencia, String secrecoesPatologicas, String calculoDentario, String auscultacaoPulmonar, String auscultacaoCardiaca, String reflexoToce, String emagrecimento, String alteracaoComportamental, String observacoes, String extoscopia, String cavidadeAbdominal, String cabecaPescoco, String sistemaNervoso, String sistemaLocomotor, Boolean cansaco, Boolean tosse, String pulso, String fc, String fr, String observacoes2, String examesComplementares, String diagnostico, String prognostico, String tratamento, String retorno, LocalDateTime data) {
        this.id = id;
        this.veterinarioId = veterinarioId;
        this.proprietarioId = proprietarioId;
        this.animalId = animalId;
        this.anamnese = anamnese;
        this.estado = estado;
        this.mucosas = mucosas;
        this.linfonodos = linfonodos;
        this.tpc = tpc;
        this.turgorCutaneo = turgorCutaneo;
        this.desidratacao = desidratacao;
        this.ectoparasitas = ectoparasitas;
        this.mioclonias = mioclonias;
        this.prurido = prurido;
        this.vomito = vomito;
        this.diarreia = diarreia;
        this.inapatencia = inapatencia;
        this.secrecoesPatologicas = secrecoesPatologicas;
        this.calculoDentario = calculoDentario;
        this.auscultacaoPulmonar = auscultacaoPulmonar;
        this.auscultacaoCardiaca = auscultacaoCardiaca;
        this.reflexoToce = reflexoToce;
        this.emagrecimento = emagrecimento;
        this.alteracaoComportamental = alteracaoComportamental;
        this.observacoes = observacoes;
        this.extoscopia = extoscopia;
        this.cavidadeAbdominal = cavidadeAbdominal;
        this.cabecaPescoco = cabecaPescoco;
        this.sistemaNervoso = sistemaNervoso;
        this.sistemaLocomotor = sistemaLocomotor;
        this.cansaco = cansaco;
        this.tosse = tosse;
        this.pulso = pulso;
        this.fc = fc;
        this.fr = fr;
        this.observacoes2 = observacoes2;
        this.examesComplementares = examesComplementares;
        this.diagnostico = diagnostico;
        this.prognostico = prognostico;
        this.tratamento = tratamento;
        this.retorno = retorno;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(Long veterinarioId) {
        this.veterinarioId = veterinarioId;
    }

    public Long getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMucosas() {
        return mucosas;
    }

    public void setMucosas(String mucosas) {
        this.mucosas = mucosas;
    }

    public String getLinfonodos() {
        return linfonodos;
    }

    public void setLinfonodos(String linfonodos) {
        this.linfonodos = linfonodos;
    }

    public String getTpc() {
        return tpc;
    }

    public void setTpc(String tpc) {
        this.tpc = tpc;
    }

    public String getTurgorCutaneo() {
        return turgorCutaneo;
    }

    public void setTurgorCutaneo(String turgorCutaneo) {
        this.turgorCutaneo = turgorCutaneo;
    }

    public String getDesidratacao() {
        return desidratacao;
    }

    public void setDesidratacao(String desidratacao) {
        this.desidratacao = desidratacao;
    }

    public Boolean getEctoparasitas() {
        return ectoparasitas;
    }

    public void setEctoparasitas(Boolean ectoparasitas) {
        this.ectoparasitas = ectoparasitas;
    }

    public Boolean getMioclonias() {
        return mioclonias;
    }

    public void setMioclonias(Boolean mioclonias) {
        this.mioclonias = mioclonias;
    }

    public String getPrurido() {
        return prurido;
    }

    public void setPrurido(String prurido) {
        this.prurido = prurido;
    }

    public Boolean getVomito() {
        return vomito;
    }

    public void setVomito(Boolean vomito) {
        this.vomito = vomito;
    }

    public Boolean getDiarreia() {
        return diarreia;
    }

    public void setDiarreia(Boolean diarreia) {
        this.diarreia = diarreia;
    }

    public String getInapatencia() {
        return inapatencia;
    }

    public void setInapatencia(String inapatencia) {
        this.inapatencia = inapatencia;
    }

    public String getSecrecoesPatologicas() {
        return secrecoesPatologicas;
    }

    public void setSecrecoesPatologicas(String secrecoesPatologicas) {
        this.secrecoesPatologicas = secrecoesPatologicas;
    }

    public String getCalculoDentario() {
        return calculoDentario;
    }

    public void setCalculoDentario(String calculoDentario) {
        this.calculoDentario = calculoDentario;
    }

    public String getAuscultacaoPulmonar() {
        return auscultacaoPulmonar;
    }

    public void setAuscultacaoPulmonar(String auscultacaoPulmonar) {
        this.auscultacaoPulmonar = auscultacaoPulmonar;
    }

    public String getAuscultacaoCardiaca() {
        return auscultacaoCardiaca;
    }

    public void setAuscultacaoCardiaca(String auscultacaoCardiaca) {
        this.auscultacaoCardiaca = auscultacaoCardiaca;
    }

    public String getReflexoToce() {
        return reflexoToce;
    }

    public void setReflexoToce(String reflexoToce) {
        this.reflexoToce = reflexoToce;
    }

    public String getEmagrecimento() {
        return emagrecimento;
    }

    public void setEmagrecimento(String emagrecimento) {
        this.emagrecimento = emagrecimento;
    }

    public String getAlteracaoComportamental() {
        return alteracaoComportamental;
    }

    public void setAlteracaoComportamental(String alteracaoComportamental) {
        this.alteracaoComportamental = alteracaoComportamental;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getExtoscopia() {
        return extoscopia;
    }

    public void setExtoscopia(String extoscopia) {
        this.extoscopia = extoscopia;
    }

    public String getCavidadeAbdominal() {
        return cavidadeAbdominal;
    }

    public void setCavidadeAbdominal(String cavidadeAbdominal) {
        this.cavidadeAbdominal = cavidadeAbdominal;
    }

    public String getCabecaPescoco() {
        return cabecaPescoco;
    }

    public void setCabecaPescoco(String cabecaPescoco) {
        this.cabecaPescoco = cabecaPescoco;
    }

    public String getSistemaNervoso() {
        return sistemaNervoso;
    }

    public void setSistemaNervoso(String sistemaNervoso) {
        this.sistemaNervoso = sistemaNervoso;
    }

    public String getSistemaLocomotor() {
        return sistemaLocomotor;
    }

    public void setSistemaLocomotor(String sistemaLocomotor) {
        this.sistemaLocomotor = sistemaLocomotor;
    }

    public Boolean getCansaco() {
        return cansaco;
    }

    public void setCansaco(Boolean cansaco) {
        this.cansaco = cansaco;
    }

    public Boolean getTosse() {
        return tosse;
    }

    public void setTosse(Boolean tosse) {
        this.tosse = tosse;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getObservacoes2() {
        return observacoes2;
    }

    public void setObservacoes2(String observacoes2) {
        this.observacoes2 = observacoes2;
    }

    public String getExamesComplementares() {
        return examesComplementares;
    }

    public void setExamesComplementares(String examesComplementares) {
        this.examesComplementares = examesComplementares;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrognostico() {
        return prognostico;
    }

    public void setPrognostico(String prognostico) {
        this.prognostico = prognostico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
