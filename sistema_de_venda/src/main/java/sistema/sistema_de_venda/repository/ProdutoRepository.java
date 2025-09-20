package sistema.sistema_de_venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sistema.sistema_de_venda.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    
}
