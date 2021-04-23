package io.org.alefwhite.rest.dto;

import io.org.alefwhite.validation.NotEmptyList;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteDto {
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @NotEmpty(message = "{campo.telefone.obrigatorio}")
    private String telefone;

    @NotNull(message = "{campo.mensalista.mensalista}")
    private Boolean mensalista;

    private Integer diaVencimentoMensalista;

    @NotEmptyList( message = "{campo.veiculo.obrigatorio}")
    private List<VeiculoDto> veiculos;
}
