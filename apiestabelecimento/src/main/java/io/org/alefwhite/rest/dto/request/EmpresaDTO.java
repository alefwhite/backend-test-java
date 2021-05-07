package io.org.alefwhite.rest.dto.request;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {

    @NotEmpty(message = "Campo nome é obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo CPNJ é obrigatório!")
    @CNPJ( message = "Informe um CPNJ válido!")
    private String cnpj;

    @NotEmpty(message = "Campo nome é obrigatório!")
    private String endereco;

    @NotEmpty(message = "Campo nome é obrigatório!")
    private String telefone;

    @NotNull(message = "Campo quantidade de vagas de motos é obrigatório!")
    private Integer qtd_vagasMoto;

    @NotNull(message = "Campo quantidade de vagas de carros é obrigatório!")
    private Integer qtd_vagasCarro;
}
