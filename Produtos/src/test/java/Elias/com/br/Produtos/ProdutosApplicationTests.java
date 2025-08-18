package Elias.com.br.Produtos;

import Elias.com.br.Produtos.Domain.Produtos;
import Elias.com.br.Produtos.controller.ProdutosController;
import Elias.com.br.Produtos.repository.IProdutosRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProdutosApplicationTests {

	public Produtos produto = new Produtos();

	@Autowired
	ProdutosController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@BeforeEach
	public void cadastarProduto(){

		produto.setNome("Boneco do Batman");
		produto.setDescricao("Boneco do Batman");
		produto.setCodigo("123465");
		produto.setValor(new BigDecimal("49.99"));

		controller.cadastrarProdutos(produto);
	}


	@AfterEach
	public void RemoverCliente(){
		controller.deletarProduto(produto);
	}

	@Test
	public void testBuscarCliente(){
		Optional<Produtos> produtoTest =  controller.buscaProdutosPorCodigo("123465");

		assertThat(produtoTest).isNotNull();

	}

	@Test
	public void testAterarProduto(){

		controller.alterarNomeProduto("05", "Boneco do superMen");
		controller.alterarDescricaoProduto("05", "Boneco do SuperMen");
		controller.alterarValorProduto("05", new BigDecimal("59.99") );


		Produtos produtoTest = controller.buscaProdutosPorID("05").orElseThrow(() ->
				new RuntimeException("Produto não encontrado"));

		assertThat(produtoTest.getNome()).isEqualTo("Boneco do superMen");
		assertThat(produtoTest.getDescricao()).isEqualTo("Boneco do SuperMen");
		assertThat(produtoTest.getValor()).isEqualTo(new BigDecimal("59.99"));

	}

	@Test
	public void testDeletarProduto(){


		Produtos produtoTest = new Produtos();

		produtoTest.setNome("Boneco do Batman");
		produtoTest.setDescricao("Boneco do Batman");
		produtoTest.setCodigo("123465");
		produtoTest.setValor(new BigDecimal("49.99"));
		controller.cadastrarProdutos(produtoTest);

		controller.deletarProduto(produtoTest);

		Optional<Produtos> produto2 = controller.buscaProdutosPorID("07");

		assertThat(produto2).isNull();


	}


}
