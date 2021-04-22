package io.org.alefwhite.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteDto {
    private String cpf;
    private String nome;
    private String telefone;
    private Boolean mensalista;
    private Integer diaVencimentoMensalista;
    private String cor;
    private String marca;
    private String placa;
    private String modelo;
    private char tipoVeiculo;
}
