package Elias.com.br.Vendas.Domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

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
    private ProdutoQuantidade produtos;

    @NotNull
     private status statusVenda;

    @NotNull
    @Size(min = 2, max = 10)
    @Indexed(unique = true, background = true)
    private String codigo;

    // Cliente ( Como colocar uma instancia de Cliente aqui )
    @NotNull
    private String clienteId;

    private Set<ProdutoQuantidade> produtoQuantidades;

    private BigDecimal valorTotal;

}
