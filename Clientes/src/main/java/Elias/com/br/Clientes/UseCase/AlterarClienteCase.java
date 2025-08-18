package Elias.com.br.Clientes.UseCase;

import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlterarClienteCase {

    IClientesRepository clientesRepository;

    @Autowired
    public AlterarClienteCase(IClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public Clientes auterarNomeCliente(String id, String nome){
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);

        Clientes clienteAtualizado = clienteExistente.get();

        clienteAtualizado.setNome(nome);

        return clientesRepository.save(clienteAtualizado);

    }



    public Clientes auterarTelefoneCliente(String id, Integer telefone){
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);

        Clientes clienteAtualizado = clienteExistente.get();

        clienteAtualizado.setTel(telefone);

        return clientesRepository.save(clienteAtualizado);

    }

    public Clientes auterarEmailCliente(String id, String email){
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);

        Clientes clienteAtualizado = clienteExistente.get();

        clienteAtualizado.setEmail(email);

        return clientesRepository.save(clienteAtualizado);
    }

    public Clientes auterarEndCliente(String id, String end){
        Optional<Clientes> clienteExistente = clientesRepository.findById(id);

        Clientes clienteAtualizado = clienteExistente.get();

        clienteAtualizado.setEnd(end);

        return clientesRepository.save(clienteAtualizado);
    }


}
