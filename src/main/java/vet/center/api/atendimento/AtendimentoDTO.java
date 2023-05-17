package vet.center.api.atendimento;

import java.util.List;
import java.util.Set;

public class AtendimentoDTO {

    private Long id;
    private Long veterinarioId;
    private Long proprietarioId;
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
