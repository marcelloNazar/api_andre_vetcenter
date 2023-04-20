package vet.center.api.domain.veterinario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {


    Page<Veterinario> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select m.ativo
            from Veterinario m
            where
            m.id = :id
            """)
    Boolean findAtivoById(Long id);
}
