package io.org.alefwhite.rest.dto;

import io.org.alefwhite.validation.NotEmptyList;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteDto {
    @NotEmpty(message = "Campo CPF é obrigatório!")
    @CPF
    private String cpf;

    @NotEmpty(message = "Campo nome é obrigatório!")
    private String nome;

    @NotEmpty(message = "Campo nome é obrigatório!")
    private String telefone;

    @NotNull(message = "Campo nome é obrigatório!")
    private Boolean mensalista;

    @NotNull(message = "Campo nome é obrigatório!")
    private Integer diaVencimentoMensalista;

    @NotEmptyList( message = "Veiculo é obrigatório!")
    private List<VeiculoDto> veiculos;
}
