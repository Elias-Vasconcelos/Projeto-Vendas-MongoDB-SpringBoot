package Elias.com.br.Produtos.UseCase;


import Elias.com.br.Produtos.Domain.Produtos;
import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscaProdutosCase {

    IProdutosRepository produtosRepository;

    @Autowired
    public BuscaProdutosCase(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Optional<Produtos> buscarPorID(String id){
        return produtosRepository.findById(id);
    }

    public Optional<Produtos> buscarPorCodigo(String codigo){
        return produtosRepository.findByCodigo(codigo);
    }

    public List<Produtos> buscarTodos(){
        return produtosRepository.findAll();
    }



}
