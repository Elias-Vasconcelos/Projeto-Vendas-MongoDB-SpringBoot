package Elias.com.br.Vendas.UseCase;

import Elias.com.br.Vendas.Client.ProdutoClient;
import Elias.com.br.Vendas.Domain.ProdutoQuantidade;
import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static Elias.com.br.Vendas.Domain.Vendas.status.Iniciada;

@Service
public class RemoverProdutoCase {


    private IVendasRepository repository;
    private ProdutoClient produtoClient;
    private BuscaVendaCase buscar;

    @Autowired
    public RemoverProdutoCase(IVendasRepository repository, ProdutoClient produtoClient, BuscaVendaCase buscar) {
        this.repository = repository;
        this.produtoClient = produtoClient;
        this.buscar = buscar;
    }

    public void RemoveProdutoVenda(String vendaId,String produtoId){

        Vendas venda = buscar.buscarPorId(vendaId);


        if(venda !=  null){
            if(venda.getStatusVenda() == Iniciada){
                Map<String, ProdutoQuantidade> produtos =  venda.getProdutoQuantidades();

                if(produtos.containsKey(produtoId)){
                    ProdutoQuantidade produto = produtos.get(produtoId);
                    if (produto.getQuantidade()  <= 2 ){
                        produto.setQuantidade(produto.getQuantidade() - 1);
                        venda.setProdutoQuantidades(produtos);
                    } else {
                        produtos.remove(produtoId);
                        venda.setProdutoQuantidades(produtos);
                    }
                } else {
                    throw new RuntimeException("Produto não encontrada com o id:" + produtoId );
                }


            }else {
                throw new RuntimeException("a venda com ID:" + vendaId + " não pode ser alterada" );
            }


        } else {
            throw new RuntimeException("Venda não encontrada com o id:" + vendaId );
        }


        repository.save(venda);

    }



}
