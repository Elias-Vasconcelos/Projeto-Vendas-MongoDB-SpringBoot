package Elias.com.br.Produtos.repository;


import Elias.com.br.Produtos.Domain.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProdutosRepository extends MongoRepository<Produtos, String> {

    Optional<Produtos> findByCodigo(String codigo);
}
