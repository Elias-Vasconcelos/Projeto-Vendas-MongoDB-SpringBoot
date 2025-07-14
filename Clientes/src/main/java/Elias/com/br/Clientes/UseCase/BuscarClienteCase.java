package Elias.com.br.Clientes.UseeCase;

import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarClienteCase {

    IClientesRepository clientesRepository;

    @Autowired
    public BuscarClienteCase(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public Optional<Clientes> buscarPorId(String id){
        return clientesRepository.findById(id);
    }

    public Optional<Clientes> buscarPorCpf(Integer cpf){
        return clientesRepository.findByCpf(cpf);
    }

    public List<Clientes> buscarTodos(){
        return clientesRepository.findAll();
    }

}
