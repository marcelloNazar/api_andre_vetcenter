package vet.center.api.domain.proprietario;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    Page<Proprietario> findAllByAtivoTrue(Pageable paginacao);
}

