package vet.center.api.atendimento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vet.center.api.domain.animal.Animal;
import vet.center.api.domain.produto.ProdutoDTO;
import vet.center.api.domain.proprietario.Proprietario;
import vet.center.api.domain.servico.ServicoDTO;
import vet.center.api.user.User;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoResponseDTO {
    private Long id;
    private BigDecimal total;
    private Boolean pago;
    private Boolean concluido;
    private User veterinario;
    private Animal animal;
    private Proprietario proprietario;
    private List<ProdutoDTO> produtos;
    private List<ServicoDTO> servicos;
}
