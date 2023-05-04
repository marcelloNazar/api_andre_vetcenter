package vet.center.api.consulta;

import java.time.LocalDateTime;

public record DadosDetalhados(Long id, Long idVeterinario, Long idAnimal, Long idProprietario, Long idProduto, Long idServico, LocalDateTime data) {
    public DadosDetalhados(Consulta consulta) {
        this(consulta.getId(), consulta.getVeterinario().getId(), consulta.getAnimal().getId(), consulta.getProprietario().getId(), consulta.getProduto().getId(), consulta.getServico().getId(), consulta.getData());
    }
}
