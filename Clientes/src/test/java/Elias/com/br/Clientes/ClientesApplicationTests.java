package Elias.com.br.Clientes;

import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.controller.ClientesController;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ClientesApplicationTests {

	@Autowired
	private IClientesRepository clientesRepository;

	@Autowired
	private ClientesController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(clientesRepository).isNotNull();
	}

//	@Test
//	public void cadastroCliente() {
//		Clientes clienteTest = new Clientes(
//				"1223", "Elias", 155523456,
//				"Eliaaas@gmail.com", 9123456,
//				"Teste", 10, "TestCit", "Sp"
//		);
//
 //		Clientes salvo = controller.cadastrar(clienteTest);
//
//
//	}
}