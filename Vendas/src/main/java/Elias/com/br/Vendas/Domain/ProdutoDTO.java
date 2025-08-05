package Elias.com.br.Vendas.Domain;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    private String id;

    private String codigo;

    private String nome;

    private String descricao;

    private BigDecimal valor;

}
