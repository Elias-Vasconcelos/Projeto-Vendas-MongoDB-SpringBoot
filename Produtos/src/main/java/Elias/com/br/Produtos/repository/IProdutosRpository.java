package Elias.com.br.Produtos.repository;


import Elias.com.br.Produtos.Domain.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutosRpository extends MongoRepository<Produtos, String> {

}
