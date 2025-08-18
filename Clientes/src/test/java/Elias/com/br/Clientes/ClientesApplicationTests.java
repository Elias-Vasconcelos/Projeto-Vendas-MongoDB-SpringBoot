package Elias.com.br.Clientes;

import Elias.com.br.Clientes.Domain.Clientes;
import Elias.com.br.Clientes.controller.ClientesController;
import Elias.com.br.Clientes.repository.IClientesRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class ClientesApplicationTests {

	@Autowired
	static ClientesController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	static Clientes clienteTest = new Clientes();


	@BeforeEach
	public void cadastroCliente() {

		clienteTest.setNome("Elias");
		clienteTest.setCpf(123456789);
		clienteTest.setEmail("Elias@gmail.com");
		clienteTest.setEnd("Rua Test");
		clienteTest.setNumero(999);
		clienteTest.setEstado("São paulo");
		clienteTest.setCidade("São paulo");
		clienteTest.setTel(1199999999);
		controller.cadastrarCliente(clienteTest);

	}


	@AfterEach
	public void removerCliente() {
		controller.deletarCliente(clienteTest);
	}



	@Test
	public void testBuscarCliente(){
		Clientes cliente = controller.buscarClientePorCpf(123456789).orElseThrow(() ->
				new RuntimeException("Cliente não encontrada com o Cpf: " + clienteTest.getCpf()));


		assertThat(cliente).isNotNull();

	}


	@Test
	public  void testAlterarCliente(){

        controller.alterarClienteEmail("011",  "Email.atualizado");
		controller.alterarClienteNome("011", "NomeAtualizado" );
		controller.alterarClienteTelefone("011", 119111111);
		controller.alterarClienteEnd("011", "RuaAtualizada");

		Clientes cliente = controller.buscarClientePorId("011").orElseThrow(() ->
					new RuntimeException("Cliente não encontrada com o id fornecido"));

		assertThat(cliente.getEmail()).isEqualTo("Email.atualizado");
		assertThat(cliente.getNome()).isEqualTo("NomeAtualizado");
		assertThat(cliente.getTel()).isEqualTo(119111111);
		assertThat(cliente.getEnd()).isEqualTo("RuaAtualizada");
	}


//	@Test
//	public void cadastroCliente(){
//		Clientes cliente = Clientes.builder()
//				.id("1")
//				.nome("Elias Ferreira")
//				.cpf("12345678900")
//				.email("elias@email.com")
//				.build();
//
//		controller.cadastrarCliente(cliente);
//
//		clientesRepository.findById();
//
//
//	}



}