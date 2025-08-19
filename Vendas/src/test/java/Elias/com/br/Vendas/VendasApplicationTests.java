package Elias.com.br.Vendas;

import Elias.com.br.Vendas.Controller.VendasController;
import Elias.com.br.Vendas.Domain.ProdutoQuantidade;
import Elias.com.br.Vendas.Domain.Vendas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VendasApplicationTests {

	@Autowired
	static VendasController controller;


	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}



	@Test
	public  void criarVenda(){

		controller.cadastrarVenda("011");

		Optional<Vendas> vendaTest = controller.buscarVenda("02");

		assertThat(vendaTest).isEmpty();

	}

	@Test
	public void buscarVenda(){
		Optional<Vendas> vendaTest = controller.buscarVendaPorCodigo("3f6f1a62-3e91-4f74-9c1a-0f8a2f6a3e8a");

		assertThat(vendaTest).isEmpty();
	}


	@Test
	public void CancelarVenda(){

		controller.cancelarVenda("02");

		Vendas vendaTest = controller.buscarVenda("02").orElseThrow( () ->
				new RuntimeException( "Venda não encontrada")  );

		assertThat(vendaTest.getStatusVenda()).isEqualTo( Vendas.status.Cancelada);


	}

	@Test
	public void ConcluirVenda(){

	  controller.finalizarVenda("03");

		Vendas vendaTest = controller.buscarVenda("03").orElseThrow( () ->
				new RuntimeException( "Venda não encontrada")  );

		assertThat(vendaTest.getStatusVenda()).isEqualTo( Vendas.status.Concluido);


	}

	@Test
	public void adicionarProdutosVenda(){
		controller.cadastrarVenda("011");
		controller.adicionarProdotoVenda("04", "10");

		Vendas vendaTest = controller.buscarVenda("04").orElseThrow( () ->
				new RuntimeException( "Venda não encontrada")  );


		Map<String, ProdutoQuantidade> produtos =  vendaTest.getProdutoQuantidades();

		assertThat(produtos).containsKey("10");



	}




	@Test
	public void removerProdutosVenda(){
		controller.cadastrarVenda("011");

		Vendas vendaTest = controller.buscarVenda("04").orElseThrow( () ->
				new RuntimeException( "Venda não encontrada")  );


		Map<String, ProdutoQuantidade> produtos =  vendaTest.getProdutoQuantidades();



		controller.removerProdutoVenda("04", "10");

		Vendas vendaTest2 = controller.buscarVenda("04").orElseThrow( () ->
				new RuntimeException( "Venda não encontrada")  );

		Map<String, ProdutoQuantidade> produtos2 =  vendaTest2.getProdutoQuantidades();


		if (produtos2.containsKey("04")){
		    ProdutoQuantidade prouto1 = produtos.get("10");
			ProdutoQuantidade prouto2 = produtos2.get("10");


			assertThat(prouto1.getQuantidade()).isGreaterThan(prouto2.getQuantidade());

		} else {
			assertThat(produtos2).doesNotContainKey("10");
		}
	}


}
