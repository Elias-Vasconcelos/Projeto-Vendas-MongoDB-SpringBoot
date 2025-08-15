package Elias.com.br.Vendas.UseCase;


import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelarVenda {
    private IVendasRepository repository;
    private BuscaVendaCase buscar;


    @Autowired
    public CancelarVenda(IVendasRepository repository, BuscaVendaCase buscar) {
        this.repository = repository;
        this.buscar = buscar;
    }


    public void cancelarVenda(String vendaId){
        Vendas venda = buscar.buscarPorId(vendaId);
         venda.setStatusVenda(Vendas.status.Cancelada);

         repository.save(venda);

    }
}
