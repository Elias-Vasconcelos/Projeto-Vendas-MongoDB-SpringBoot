package Elias.com.br.Clientes.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.rpires.ClienteServiceProfessor.repository")
public class MongoConfig {

}