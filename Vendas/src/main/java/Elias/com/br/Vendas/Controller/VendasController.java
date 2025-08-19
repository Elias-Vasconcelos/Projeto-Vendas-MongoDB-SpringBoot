    package Elias.com.br.Vendas.Controller;

    import Elias.com.br.Vendas.Domain.Vendas;
    import Elias.com.br.Vendas.UseCase.*;
    import io.swagger.v3.oas.annotations.Operation;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.Optional;

    @RestController
    @RequestMapping("/Vendas")
    public class VendasController {

        private AdicionarProdutoCase adicionarProduto;
        private BuscaVendaCase buscar;
        private CancelarVenda cancelarVenda;
        private ConcluirVendaCase concluirVenda;
        private CriarVendaCase criarVenda;
        private RemoverProdutoCase removerProduto;


        @Autowired
        public VendasController(AdicionarProdutoCase adicionarProduto, BuscaVendaCase buscar, CancelarVenda cancelarVenda, ConcluirVendaCase concluirVenda, CriarVendaCase criarVenda, RemoverProdutoCase removerProduto) {
            this.adicionarProduto = adicionarProduto;
            this.buscar = buscar;
            this.cancelarVenda = cancelarVenda;
            this.concluirVenda = concluirVenda;
            this.criarVenda = criarVenda;
            this.removerProduto = removerProduto;
        }


        @PostMapping
        @Operation(summary = "cadastrar uma Venda")
        public void cadastrarVenda(@RequestBody @Valid String clientId){
            criarVenda.CriarVenda(clientId);
        }

        @GetMapping(value = "/ID/{id}")
        @Operation(summary = "Busca uma Venda pelo ID")
        public Optional<Vendas> buscarVenda( @PathVariable(value = "ID", required = true) String vendaId){
              return buscar.buscarPorId(vendaId);
        }

        @GetMapping(value = "/Codigo/{codigo}")
        @Operation(summary = "Busca uma Venda pelo Codigo")
        public Optional<Vendas> buscarVendaPorCodigo( @PathVariable(value = "Codigo", required = true) String codigoVenda){
            return buscar.buscarPorCodigo(codigoVenda);
        }

        @PutMapping
        @Operation(summary = "Adiciona um produto a uma venda")
        public void  adicionarProdotoVenda(@RequestBody @Valid String vendaId, String produtoId){
            adicionarProduto.adicionarProduto(vendaId, produtoId);
        }

        @PutMapping
        @Operation(summary = "Remove um produto a uma venda")
        public void removerProdutoVenda(@RequestBody @Valid String vendaId, String produtoId){
            removerProduto.RemoveProdutoVenda(vendaId, produtoId);
        }

        @PutMapping
        @Operation(summary = "Cancela uma venda")
        public void cancelarVenda(@RequestBody @Valid String vendaId){
            cancelarVenda.cancelarVenda(vendaId);
        }

        @PutMapping
        @Operation(summary = "Cancela uma venda")
        public void finalizarVenda(@RequestBody @Valid String vendaId){
            concluirVenda.concluirVenda(vendaId);
        }

    }
