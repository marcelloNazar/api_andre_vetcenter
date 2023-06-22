package vet.center.api.atendimento;

import lombok.Data;
import vet.center.api.domain.produto.AtendimentoProdutoDTO;
import vet.center.api.domain.servico.AtendimentoServicoDTO;

import java.util.List;

@Data
public class AtendimentoDTO {
    private Long veterinarioId;
    private Long animalId;
    private List<AtendimentoProdutoDTO> atendimentoProdutos;
    private List<AtendimentoServicoDTO> atendimentoServicos;
}
