package vet.center.api.domain.proprietario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProprietarioRepository extends JpaRepository<ProprietarioJPA, Long> {
    ProprietarioJPA findByNome(String nome);

    Page<ProprietarioJPA> findAllByAtivoTrue(Pageable paginacao);
}

