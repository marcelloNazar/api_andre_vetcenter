package vet.center.api.consulta;

import java.time.LocalDateTime;

public record DadosDetalhados(Long id, Long idVeterinario, Long idAnimal, Long idProduto, LocalDateTime data) {
    public DadosDetalhados(Consulta consulta) {
        this(consulta.getId(), consulta.getVeterinario().getId(), consulta.getAnimal().getId(), consulta.getProduto().getId(), consulta.getData());
    }
}
