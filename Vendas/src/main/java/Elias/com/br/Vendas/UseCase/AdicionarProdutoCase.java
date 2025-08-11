package Elias.com.br.Vendas.UseCase;


import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarProdutoCase {

  private IVendasRepository repository;
  private BuscaVendaCase buscar;

    @Autowired
    public AdicionarProdutoCase(IVendasRepository repository,BuscaVendaCase buscar ) {
        this.repository = repository;
        this.buscar = buscar;
    }

    public void adicionarProduto(String produtoId){

        Vendas venda = buscar.buscarPorId(produtoId);

        venda.adicionarProduto(produtoId);

        repository.save(venda);
    }


}
