package vet.center.api.domain.servico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoServicoRepository extends JpaRepository<AtendimentoServico, Long> {
    void deleteByAtendimentoId(Long id);
}
