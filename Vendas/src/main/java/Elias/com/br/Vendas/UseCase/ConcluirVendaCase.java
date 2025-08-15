package Elias.com.br.Vendas.UseCase;

import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcluirVendaCase {

    private IVendasRepository repository;
    private BuscaVendaCase buscar;

    @Autowired
    public ConcluirVendaCase(IVendasRepository repository, BuscaVendaCase buscar) {
        this.repository = repository;
        this.buscar = buscar;
    }


    public void concluirVenda(String vendaId){

        Vendas venda = buscar.buscarPorId(vendaId).orElseThrow(
                () -> new RuntimeException("Venda não encontrada com o id: " + vendaId));;
        venda.setStatusVenda(Vendas.status.Concluido);

        repository.save(venda);



    }



}
