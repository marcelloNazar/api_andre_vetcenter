package vet.center.api.atendimento;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
    Page<Atendimento> findAllByVeterinarioIdAndConcluidoFalse(Long veterinarioId, Pageable pageable);
    Page<Atendimento> findAllByConcluidoTrueAndPagoFalse(Pageable pageable);
    Page<Atendimento> findAllByPagoTrue(Pageable pageable);
    Page<Atendimento> findAllByConcluidoFalse(Pageable pageable);
    Page<Atendimento> findAllByFinalizadoTrue(Pageable pageable);
    Page<Atendimento> findAllByConcluidoTrueAndFinalizadoFalse(Pageable pageable);
    Page<Atendimento> findAllByVeterinarioIdAndConcluidoTrue(Long veterinarioId, Pageable pageable);
    Page<Atendimento> findAllByVeterinarioIdAndConcluidoTrueAndFinalizadoFalse(Long veterinarioId, Pageable pageable);
    Page<Atendimento> findAllByPagoFalse(Pageable pageable);
}
