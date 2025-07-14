package Elias.com.br.Clientes.UseCase;


import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarClienteCase {

    IClientesRepository clientesRepository;

    @Autowired
    public DeletarClienteCase(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }


    public void deletarClientes(Clientes cliente){
        clientesRepository.delete(cliente);
    }


}
