package Elias.com.br.Produtos;

import Elias.com.br.Produtos.controller.ProdutosController;
import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProdutosApplicationTests {

	@Autowired
	IProdutosRepository produtoRepository;

	@Autowired
	ProdutosController produtoController;

	@Test
	void contextLoads() {
		assertThat(produtoRepository).isNotNull();
		assertThat(produtoController).isNotNull();
	}



}
