package Elias.com.br.Produtos.UseCase;


import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaProdutosCase {

    IProdutosRepository produtosRepository;

    @Autowired
    public BuscaProdutosCase(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }


    
}
