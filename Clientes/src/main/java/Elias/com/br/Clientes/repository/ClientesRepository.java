package Elias.com.br.Clientes.repository;

import Elias.com.br.Clientes.Domain.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientesRepository extends MongoRepository<Clientes, String> {
}
