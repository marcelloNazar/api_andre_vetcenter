package vet.center.api.domain.proprietario;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProprietarioRepository extends JpaRepository<ProprietarioJPA, Long> {
    ProprietarioJPA findByNome(String nome);
}

