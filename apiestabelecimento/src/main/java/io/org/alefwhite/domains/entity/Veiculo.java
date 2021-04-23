package io.org.alefwhite.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.org.alefwhite.domains.enums.TipoVeiculo;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "veiculos" )
public class Veiculo implements Serializable {
    private static final Integer serialVersionUID = 1;

    public Veiculo(String modelo, String marca, String cor, String placa, TipoVeiculo tipoVeiculo) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "modelo", length = 100)
    @NotEmpty( message = "Campo modelo é obrigatório!")
    private String modelo;

    @NotEmpty( message = "Campo marca é obrigatório!")
    @Column(name = "marca", length = 100)
    private String marca;

    @NotEmpty( message = "Campo cor é obrigatório!")
    @Column(name = "cor", length = 100)
    private String cor;

    @NotEmpty( message = "Campo placa é obrigatório!")
    @Column(name = "placa", length = 7)
    private String placa;

    @NotNull( message = "Campo tipo do veiculo é obrigatório!")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo")
    private TipoVeiculo tipoVeiculo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
