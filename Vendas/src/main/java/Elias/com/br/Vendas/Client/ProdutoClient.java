package Elias.com.br.Vendas.Client;

import Elias.com.br.Vendas.Domain.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ProdutoClient {

    private final RestTemplate restTemplate;

    public ProdutoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProdutoDTO buscarProdutoPorId(String produtoId) {
        String url = "http://localhost:8081/Produtos/" + produtoId;
        return restTemplate.getForObject(url, ProdutoDTO.class);
    }



}
