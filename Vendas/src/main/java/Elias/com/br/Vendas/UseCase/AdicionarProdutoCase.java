package Elias.com.br.Vendas.UseCase;


import Elias.com.br.Vendas.Client.ProdutoClient;
import Elias.com.br.Vendas.Domain.ProdutoDTO;
import Elias.com.br.Vendas.Domain.ProdutoQuantidade;
import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AdicionarProdutoCase {

  private IVendasRepository repository;
  private ProdutoClient produtoClient;

  private BuscaVendaCase buscar;

    @Autowired
    public AdicionarProdutoCase(IVendasRepository repository,BuscaVendaCase buscar ) {
        this.repository = repository;
        this.buscar = buscar;
    }

    public void adicionarProduto(String vendaId,String produtoId){

        Vendas venda = buscar.buscarPorId(vendaId);

        if(venda != null ){
            Map<String, ProdutoQuantidade> produtos =  venda.getProdutoQuantidades();

            if(produtos.containsKey(produtoId)){
                ProdutoQuantidade produto = produtos.get(produtoId);
                produto.setQuantidade(produto.getQuantidade() + 1);
            } else {
                ProdutoDTO produtoDto = produtoClient.buscarProdutoPorId(produtoId);

                if(produtoDto != null ){
                    ProdutoQuantidade produto = new ProdutoQuantidade();
                    produto.setProdutoId(produtoId);
                    produto.setQuantidade(1);
                    produto.setValorUnitario(produtoDto.getValor());
                    produto.calcularValorTotal();
                } else {
                    throw new RuntimeException("Produto não encontrada com o id:" + produtoId );
                }
            }
        } else {
            throw new RuntimeException("Venda não encontrada com o id:" + vendaId );
        }
        repository.save(venda);
    }


}
