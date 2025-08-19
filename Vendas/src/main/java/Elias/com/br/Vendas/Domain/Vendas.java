package Elias.com.br.Vendas.Domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

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
    private String codigo;

    @NotNull
    private String clienteId;

    private Map<String,ProdutoQuantidade> produtoQuantidades;

    private BigDecimal valorTotal;


    public BigDecimal calculaValorTotal(){

        valorTotal = BigDecimal.ZERO;

        for(ProdutoQuantidade produto : produtoQuantidades.values()){

            valorTotal =  valorTotal.add(produto.getValorTotal());
        }

        return valorTotal;
    }

    public void gerarCodigo() {
        if (this.codigo == null) {
            this.codigo = UUID.randomUUID().toString();
        }
    }




}
