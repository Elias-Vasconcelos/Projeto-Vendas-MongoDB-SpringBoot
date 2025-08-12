package Elias.com.br.Vendas.UseCase;

import Elias.com.br.Vendas.Client.ClientesClient;
import Elias.com.br.Vendas.Domain.ClienteDTO;
import Elias.com.br.Vendas.Domain.ProdutoDTO;
import Elias.com.br.Vendas.Domain.Vendas;
import Elias.com.br.Vendas.Repository.IVendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarVendaCase {

    private ClientesClient clienteClient;

    private IVendasRepository repository;


    @Autowired
    public CriarVendaCase(ClientesClient clienteClient, IVendasRepository repository) {
        this.clienteClient = clienteClient;
        this.repository = repository;
    }

    public Optional<Vendas> CriarVenda(String ClienteId){

        ClienteDTO cliente = clienteClient.buscarClientePorId(ClienteId);

        if(cliente != null) {
            Vendas venda = new Vendas();

             venda.setClienteId(ClienteId);
             venda.setStatusVenda(Vendas.status.Iniciada);

             repository.save(venda);

            return Optional.of(venda);
        }

        else{
            throw new RuntimeException("Cliente não encontrado com ID: " + ClienteId);
        }

    }

    }


