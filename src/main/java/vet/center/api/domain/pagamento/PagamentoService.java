package vet.center.api.domain.pagamento;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vet.center.api.atendimento.Atendimento;
import vet.center.api.atendimento.AtendimentoRepository;
import vet.center.api.atendimento.AtendimentoService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AtendimentoService atendimentoService;

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Pagamento criarPagamento(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        Atendimento atendimento = atendimentoService.getAtendimentoById(pagamentoDTO.getAtendimentoId());
        BigDecimal novoTotal = BigDecimal.valueOf(atendimento.getTotal().doubleValue() - pagamentoDTO.getValor().doubleValue());
        atendimento.setTotal(novoTotal);
        atendimentoRepository.save(atendimento);
        pagamento.setAtendimento(atendimento);
        BeanUtils.copyProperties(pagamentoDTO, pagamento, "atendimentoId");

        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> getPagamentosPorAtendimento(Long atendimentoId) {
        return pagamentoRepository.findByAtendimentoId(atendimentoId);
    }


}
