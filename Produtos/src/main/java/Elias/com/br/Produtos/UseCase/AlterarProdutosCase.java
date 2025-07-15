package Elias.com.br.Produtos.UseCase;

import Elias.com.br.Produtos.Domain.Produtos;
import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AlterarProdutosCase {

    IProdutosRepository produtosRepository;

    @Autowired
    public AlterarProdutosCase(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public Produtos AlterarNomeProduto( String id, String nome){
        Optional<Produtos>  ProdutoExisteente = produtosRepository.findById(id);

        Produtos produtoAtualizado = ProdutoExisteente.get();

        produtoAtualizado.setNome(nome);

        return produtosRepository.save(produtoAtualizado);

    }


    public Produtos AlterarDescricaoProduto( String id, String Descricao){
        Optional<Produtos>  ProdutoExisteente = produtosRepository.findById(id);

        Produtos produtoAtualizado = ProdutoExisteente.get();

        produtoAtualizado.setDescricao(Descricao);

        return produtosRepository.save(produtoAtualizado);

    }


    public Produtos AlterarValorProduto( String id, BigDecimal Valor){
        Optional<Produtos>  ProdutoExisteente = produtosRepository.findById(id);

        Produtos produtoAtualizado = ProdutoExisteente.get();

        produtoAtualizado.setValor(Valor);

        return produtosRepository.save(produtoAtualizado);

    }




}
