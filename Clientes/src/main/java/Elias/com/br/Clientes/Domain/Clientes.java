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

    public Clientes(String id, String nome, Integer cpf, String email, Integer tel, String end, Integer numero, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tel = tel;
        this.end = end;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

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
    private Integer cpf;

    @NotNull
    @Schema(description="Telefone", nullable = false)
    @Indexed(unique = true, background = true)
    private Integer tel;

    @NotNull
    @Size(min = 1, max = 50)
    @Indexed(unique = true, background = true)
    @Schema(description="Email", minLength = 1, maxLength=50, nullable = false)
    @Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Endereço", minLength = 1, maxLength=50, nullable = false)
    private String end;

    @NotNull
    @Schema(description="Numero residencial", nullable = false)
    private Integer numero;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Cidade", minLength = 1, maxLength=50, nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 1, max = 50)
    @Schema(description="Estado", minLength = 1, maxLength=50, nullable = false)
    private String estado;

}
