package vet.center.api.domain.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoProdutoRepository extends JpaRepository<AtendimentoProduto, Long> {
    void deleteByAtendimentoId(Long id);
}
