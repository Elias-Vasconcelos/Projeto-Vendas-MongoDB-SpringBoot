package Elias.com.br.Vendas.Domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private String id;

    private String nome;

    private Integer cpf;

    private Integer tel;

    private String email;

    private String end;

    private Integer numero;

    private String cidade;

    private String estado;

}
