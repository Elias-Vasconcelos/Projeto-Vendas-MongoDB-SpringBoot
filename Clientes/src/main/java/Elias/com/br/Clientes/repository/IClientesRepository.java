package Elias.com.br.Clientes.repository;

import Elias.com.br.Clientes.Domain.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientesRepository extends MongoRepository<Clientes, String> {

    Optional<Clientes> findByCpf(Integer cpf);
}
