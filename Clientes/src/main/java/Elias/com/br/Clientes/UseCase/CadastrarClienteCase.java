package Elias.com.br.Clientes.UseeCase;

import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarClienteCase {

    IClientesRepository clientesRepository;

    @Autowired
    public CadastrarClienteCase(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }



    public Clientes cadastrarCliente(Clientes cliente) {
       return clientesRepository.save(cliente);
    }

}
