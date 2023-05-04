package vet.center.api.atendimento;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import vet.center.api.domain.produto.Produto;
import vet.center.api.domain.servico.Servico;

import java.time.LocalDateTime;
import java.util.List;

public record DadosAtendimento(
        Long veterinario_id,
        Long animal_id,
        Long proprietario_id,
        List<Produto> produtos,
        List<Servico> servicos,

        @NotNull
        @Future
        LocalDateTime data) {
}
