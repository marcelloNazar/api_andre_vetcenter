package vet.center.api.domain.animal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animal, Long> {


    Page<Animal> findAllByAtivoTrue(Pageable paginacao);
}
