package Elias.com.br.Vendas.Client;

import Elias.com.br.Vendas.Domain.ClienteDTO;
import Elias.com.br.Vendas.Domain.ProdutoDTO;
import org.springframework.web.client.RestTemplate;

public class ClientesClient {

    private final RestTemplate restTemplate;

    public ClientesClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ClienteDTO buscarClientePorId(String clienteId) {
        String url = "http://localhost:8081/Clientes/" + clienteId;
        return restTemplate.getForObject(url, ClienteDTO.class);
    }





}
