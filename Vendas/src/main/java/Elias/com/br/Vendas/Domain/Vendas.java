package Elias.com.br.Vendas.Domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Map;

@Document(collection = "Vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Vendas", description ="Vendas")
public class Vendas {

    public enum status {
        Iniciada,
        Cancelada,
        Concluido
    }

    @Id
     private String id;

    @NotNull
     private status statusVenda;

    @NotNull
    private String clienteId;

    private Map<String,ProdutoQuantidade> produtoQuantidades;

    private BigDecimal valorTotal;


    public void adicionarProduto(String produtoId){
      //  produtoQuantidades.put()

        if(produtoQuantidades.containsKey(produtoId)){
            ProdutoQuantidade produto = produtoQuantidades.get(produtoId);
            produto.setQuantidade(produto.getQuantidade() + 1);
        }
//        produtoQuantidades.containsKey(produtoId);
//        produtoQuantidades.get(produtoId);
    }

}
