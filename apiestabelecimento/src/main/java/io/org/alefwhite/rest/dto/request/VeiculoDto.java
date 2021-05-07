package io.org.alefwhite.rest.dto.request;

import io.org.alefwhite.domains.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto {
    @NotEmpty(message = "Campo cor é obrigatório!")
    private String cor;

    @NotEmpty(message = "Campo marca é obrigatório!")
    private String marca;

    @NotEmpty(message = "Campo placa é obrigatório!")
    private String placa;

    @NotEmpty(message = "Campo modelo é obrigatório!")
    private String modelo;

    @NotNull(message = "Campo tipo do veiculo é obrigatório!")
    private TipoVeiculo tipoVeiculo;

    @NotNull(message = "Campo cliente é obrigatório!")
    private Integer idCliente;

}
