package vet.center.api.domain.produto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Page<Produto> getAllProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto produtoDetails) {
        Produto produto = getProdutoById(id);

        if (produtoDetails.getNome() != null) {
            produto.setNome(produtoDetails.getNome());
        }
        if (produtoDetails.getValor() != null) {
            produto.setValor(produtoDetails.getValor());
        }
        if (produtoDetails.getDescricao() != null) {
            produto.setDescricao(produtoDetails.getDescricao());
        }
        if (produtoDetails.getEstoque() != null) {
            produto.setEstoque(produtoDetails.getEstoque());
        }

        return produtoRepository.save(produto);
    }

    public void deleteProduto(Long id) {
        Produto produto = getProdutoById(id);
        produtoRepository.delete(produto);
    }
}
