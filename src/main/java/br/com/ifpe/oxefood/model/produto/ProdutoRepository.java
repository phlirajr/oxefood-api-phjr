package br.com.ifpe.oxefood.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{
    
}
