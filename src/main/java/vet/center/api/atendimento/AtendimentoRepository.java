package vet.center.api.atendimento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Page<Atendimento> findAllByVeterinarioId(Long veterinarioId, Pageable pageable);
    Page<Atendimento> findAllByConcluidoTrue(Pageable pageable);
    Page<Atendimento> findAllByPagoTrue(Pageable pageable);
    Page<Atendimento> findAllByConcluidoFalse(Pageable pageable);
}
