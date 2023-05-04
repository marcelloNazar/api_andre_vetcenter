package vet.center.api.atendimento;

import java.util.List;

public class DtoAtendimento {

    private Long id;
    private Long veterinario_id;
    private Long animal_id;
    private Long proprietario_id;

    private List<Long> servico_id;

    private List<Long> produto_id;

}
