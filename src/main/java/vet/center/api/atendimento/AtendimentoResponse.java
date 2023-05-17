package vet.center.api.atendimento;

import java.util.List;

public class AtendimentoResponse {

    private Long id;
    private Long veterinarioId;
    private String veterinarioNome;
    private Long proprietarioId;
    private String proprietarioNome;
    private Long animalId;
    private List<Long> produtosIds;
    private List<Long> servicosIds;



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

    public String getVeterinarioNome() {
        return veterinarioNome;
    }

    public void setVeterinarioNome(String veterinarioNome) {
        this.veterinarioNome = veterinarioNome;
    }

    public Long getProprietarioId() {
        return proprietarioId;
    }

    public void setProprietarioId(Long proprietarioId) {
        this.proprietarioId = proprietarioId;
    }

    public String getProprietarioNome() {
        return proprietarioNome;
    }

    public void setProprietarioNome(String proprietarioNome) {
        this.proprietarioNome = proprietarioNome;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }

    public List<Long> getProdutosIds() {
        return produtosIds;
    }

    public void setProdutosIds(List<Long> produtosIds) {
        this.produtosIds = produtosIds;
    }

    public List<Long> getServicosIds() {
        return servicosIds;
    }

    public void setServicosIds(List<Long> servicosIds) {
        this.servicosIds = servicosIds;
    }
}
