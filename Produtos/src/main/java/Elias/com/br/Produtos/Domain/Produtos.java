package Elias.com.br.Produtos.Domain;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Document(collection = "Produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Produtos", description ="Produtos")
public class Produtos {

    @Id
    private String id;

    @NotNull
    @Size(min = 2, max = 10)
    @Indexed(unique = true, background = true)
    private String codigo;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Nome do Produto")
    private String nome;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description = "Descricao breve do Produto")
    private String descricao;

    @NotNull
    @Schema(description = "edscricao breve do Produto")
    private BigDecimal valor;

}


