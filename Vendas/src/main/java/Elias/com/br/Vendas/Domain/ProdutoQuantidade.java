package Elias.com.br.Vendas.Domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Document(collection = "Produto Quantidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Produto Quantidade", description ="Produto Quantidade")
public class ProdutoQuantidade {

    @NotNull
    private String produtoId;

    private BigDecimal valortotal;

    private Integer quantidade;
    
}
