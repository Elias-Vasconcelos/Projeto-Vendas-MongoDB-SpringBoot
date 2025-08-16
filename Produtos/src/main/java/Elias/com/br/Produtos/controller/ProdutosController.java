package Elias.com.br.Produtos.controller;


import Elias.com.br.Produtos.Domain.Produtos;
import Elias.com.br.Produtos.UseCase.AlterarProdutosCase;
import Elias.com.br.Produtos.UseCase.BuscaProdutosCase;
import Elias.com.br.Produtos.UseCase.CadastrarProdutosCase;
import Elias.com.br.Produtos.UseCase.DeletarProdutosCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Produtos")
public class ProdutosController {

    private CadastrarProdutosCase cadastrar;
    private AlterarProdutosCase alterar;
    private BuscaProdutosCase buscar;
    private DeletarProdutosCase deletar;

    @Autowired
    public ProdutosController(CadastrarProdutosCase cadastrar, AlterarProdutosCase alterar, BuscaProdutosCase buscar, DeletarProdutosCase deletar) {
        this.cadastrar = cadastrar;
        this.alterar = alterar;
        this.buscar = buscar;
        this.deletar = deletar;
    }

    @PostMapping
    @Operation(summary = "cadastrar um produto")
    public Produtos cadastrarProdutos(@RequestBody @Valid Produtos produto){
        return cadastrar.cadastrarProdutos(produto);
    }

    @PutMapping
    @Operation(summary = "Atualiza um Produto")
    public Produtos alterarNomeProduto(@RequestBody @Valid String id, String nome){
        return alterar.AlterarNomeProduto(id, nome);
    }

    @PutMapping
    @Operation(summary = "Atualiza um Produto")
    public Produtos alterarDescricaoProduto(@RequestBody @Valid String id, String Descricao){
        return alterar.AlterarDescricaoProduto(id, Descricao);
    }

    @PutMapping
    @Operation(summary = "Atualiza um Produto")
    public Produtos alterarValorProduto(@RequestBody @Valid String id, BigDecimal valor){
        return alterar.AlterarValorProduto(id, valor);
    }

    @GetMapping(value = "/Codigo/{codigo}")
    @Operation(summary = "Busca um Produto pelo codigo")
    public Optional<Produtos> buscaProdutosPorCodigo(@PathVariable(value = "codigo", required = true) String codigo){
        return buscar.buscarPorCodigo(codigo);
    }

    @GetMapping(value = "/ID/{id}")
    @Operation(summary = "Busca um Produto pelo ID")
    public Optional<Produtos> buscaProdutosPorID(@PathVariable(value = "ID", required = true) String id){
        return buscar.buscarPorID(id);
    }

    @GetMapping
    @Operation(summary = "Busca Todos os Produtos")
    public List<Produtos> buscaTodosProdutos(){
        return buscar.buscarTodos();
    }

    @DeleteMapping
    @Operation(summary = "Remove um produto do banco de dados")
    public void deletarProduto(Produtos produto){
        deletar.deletarProduto(produto);
    }



}
