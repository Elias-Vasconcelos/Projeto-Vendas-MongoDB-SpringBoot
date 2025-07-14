package Elias.com.br.Clientes.controller;


import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.UseCase.AlterarClienteCase;
import Elias.com.br.Clientes.UseCase.BuscarClienteCase;
import Elias.com.br.Clientes.UseCase.CadastrarClienteCase;
import Elias.com.br.Clientes.UseCase.DeletarClienteCase;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/Clientes")
public class ClientesController {

    private AlterarClienteCase alterar;
    private BuscarClienteCase buscar;
    private CadastrarClienteCase cadastrar;
    private DeletarClienteCase deletar;

    @Autowired
    public ClientesController(AlterarClienteCase alterar, BuscarClienteCase buscar, CadastrarClienteCase cadastrar, DeletarClienteCase deletar) {
        this.alterar = alterar;
        this.buscar = buscar;
        this.cadastrar = cadastrar;
        this.deletar = deletar;
    }

    @PostMapping
    @Operation(summary = "cadastrar um cliente")
    public Clientes cadastrarCliente(@RequestBody @Valid Clientes cliente) {
      return cadastrar.cadastrarCliente(cliente);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Clientes alterarClienteNome(@RequestBody @Valid String id, String nome){
        return alterar.auterarNomeCliente(id, nome);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Clientes alterarClienteTelefone(@RequestBody @Valid String id, Integer telefone){
        return  alterar.auterarTelefoneCliente(id,telefone);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Clientes alterarClienteEmail(@RequestBody @Valid String id, String email){
        return alterar.auterarEmailCliente(id, email);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Clientes alterarClienteEnd(@RequestBody @Valid String id, String end){
        return alterar.auterarEndCliente(id, end);
    }


    @GetMapping(value = "/ID/{id}")
    @Operation(summary = "Busca um cliente pelo ID")
    public Optional<Clientes> buscarClientePorId(@PathVariable(value = "id", required = true) String id){
         Optional<Clientes> clienteExistente = buscar.buscarPorId(id);

        if (clienteExistente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }

         return clienteExistente;
    }

    @GetMapping(value = "/CPF/{cpf}")
    @Operation(summary = "Busca um cliente pelo Cpf")
    public Optional<Clientes> buscarClientePorCpf(@PathVariable(value = "cpf", required = true) Integer cpf){
        Optional<Clientes> clienteExistente = buscar.buscarPorCpf(cpf);

        if (clienteExistente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado com o cpf: " + cpf);
        }

        return clienteExistente;
    }

    @GetMapping()
    @Operation(summary = "Busca Todos Clientes")
    public List<Clientes> buscarTodosClientes(){
        return buscar.buscarTodos();
    }

    @DeleteMapping
    @Operation(summary = "Remove um Cliente")
    public void deletarCliente(Clientes cliente){
        deletar.deletarClientes(cliente);
    }

}
