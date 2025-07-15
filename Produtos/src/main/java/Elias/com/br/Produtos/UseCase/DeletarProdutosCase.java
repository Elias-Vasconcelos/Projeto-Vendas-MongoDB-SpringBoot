package Elias.com.br.Produtos.UseCase;


import Elias.com.br.Produtos.Domain.Produtos;
import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarProdutosCase {

    IProdutosRepository produtosRepository;

    @Autowired
    public DeletarProdutosCase(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public void deletarClientes(Produtos produto){
        produtosRepository.delete(produto);
    }

}
