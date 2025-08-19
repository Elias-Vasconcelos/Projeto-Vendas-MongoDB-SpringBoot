package Elias.com.br.Vendas.UseCase;


import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaVendaCase {

  private IVendasRepository repository;


    @Autowired
    public BuscaVendaCase(IVendasRepository repository) {
        this.repository = repository;
    }


    public Optional<Vendas> buscarPorCodigo(String codigo){
        return repository.buscarPorCodigo(codigo);
    }

    public Optional<Vendas> buscarPorId(String id){
        return repository.findById(id);
    }

}
