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
    @Operation(summary = "Atualiza um cliente")
    public Produtos alterarNomeProduto(String id, String nome){
        return alterar.AlterarNomeProduto(id, nome);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Produtos alterarDescricaoProduto(String id, String Descricao){
        return alterar.AlterarDescricaoProduto(id, Descricao);
    }

    @PutMapping
    @Operation(summary = "Atualiza um cliente")
    public Produtos alterarValorProduto(String id, BigDecimal valor){
        return alterar.AlterarValorProduto(id, valor);
    }


}
