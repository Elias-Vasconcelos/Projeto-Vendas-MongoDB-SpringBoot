package Elias.com.br.Clientes.controller;


import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Clientes")
public class ClientesController {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping
    public Clientes cadastrar(@RequestBody Clientes cliente) {
      return clientesRepository.save(cliente);
    }

}
