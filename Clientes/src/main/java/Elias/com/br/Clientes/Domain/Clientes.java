package Elias.com.br.Clientes.Domain;

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


@Document(collection = "Clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name="Clientes", description ="Clientes")
public class Clientes {

    @Id
    @NotNull
    @Schema(description = "Identificador unico de Clintes")
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="nome", nullable = false)
    private String nome;

    @NotNull
    @Indexed(unique = true, background = true)
    @Schema(description="Cpf", nullable = false)
    private Long cpf;

    @NotNull
    @Schema(description="Telefone", nullable = false)
    private Long tel;

    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Endereço", minLength = 1, maxLength=50, nullable = false)
    private String end;
}
