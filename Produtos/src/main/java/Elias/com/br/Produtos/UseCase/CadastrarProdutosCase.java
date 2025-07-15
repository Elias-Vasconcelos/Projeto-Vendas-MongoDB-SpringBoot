package Elias.com.br.Produtos.UseCase;

import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarProdutosCase {

    IProdutosRepository produtosRepository;

    @Autowired
    public CadastrarProdutosCase(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }




}
