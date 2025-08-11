package Elias.com.br.Vendas.Repository;

import Elias.com.br.Vendas.Domain.Vendas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVendasRepository extends MongoRepository<Vendas, String> {

    Vendas buscarPorCodigo(String codigo);
}
