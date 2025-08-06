package Elias.com.br.Vendas.UseCase;

import Elias.com.br.Vendas.Client.ClientesClient;
import Elias.com.br.Vendas.Domain.ClienteDTO;
import Elias.com.br.Vendas.Domain.ProdutoDTO;
import Elias.com.br.Vendas.Domain.Vendas;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarVendaCase {

    private ClientesClient clienteClient;


    public Optional<Vendas> CriarVenda(String ClienteId){

        ClienteDTO cliente = clienteClient.buscarClientePorId(ClienteId);

        if(cliente != null) {
            Vendas venda = new Vendas();

             venda.setClienteId(ClienteId);
             venda.setStatusVenda(Vendas.status.Iniciada);

            return Optional.of(venda);
        }

        else{
            throw new RuntimeException("Cliente não encontrado com ID: " + ClienteId);
        }

    }

    }


