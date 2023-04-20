package vet.center.api.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByVeterinarioIdAndData(Long idVeterinario, LocalDateTime data);
}
