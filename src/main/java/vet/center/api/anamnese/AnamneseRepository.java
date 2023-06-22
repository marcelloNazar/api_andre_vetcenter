package vet.center.api.anamnese;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {

    List<Anamnese> findAnamneseByAtendimentoId(Long atendimentoId);
}
