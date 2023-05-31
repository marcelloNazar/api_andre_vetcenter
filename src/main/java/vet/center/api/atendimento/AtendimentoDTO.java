package vet.center.api.atendimento;

import lombok.Data;


import java.util.List;

@Data
public class AtendimentoDTO {
    private Long veterinarioId;
    private Long animalId;
    private List<Long> produtosIds;
    private List<Long> servicosIds;
}
