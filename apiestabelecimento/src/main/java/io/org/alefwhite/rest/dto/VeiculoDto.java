package io.org.alefwhite.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDto {
    private String cor;
    private String marca;
    private String placa;
    private String modelo;
    private char tipoVeiculo;
    private Integer idCliente;

}
