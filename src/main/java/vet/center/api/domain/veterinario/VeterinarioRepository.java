package vet.center.api.domain.veterinario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {


    Page<Veterinario> findAllByAtivoTrue(Pageable paginacao);
}
