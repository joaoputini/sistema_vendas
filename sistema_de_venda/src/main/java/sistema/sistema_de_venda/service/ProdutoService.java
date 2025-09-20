package sistema.sistema_de_venda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sistema.sistema_de_venda.model.Produto;
import sistema.sistema_de_venda.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    ProdutoRepository produtoRepository;

    //CREATE
    @Transactional
    public Produto salvar(Produto produto){
       return produtoRepository.save(produto);
        
    }
}
