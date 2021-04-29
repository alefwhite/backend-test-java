package io.org.alefwhite.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.org.alefwhite.domains.enums.TipoVeiculo;
import lombok.*;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "modelo", length = 100)
    private String modelo;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "cor", length = 100)
    private String cor;

    @Column(name = "placa", length = 7)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_veiculo")
    private TipoVeiculo tipoVeiculo;

}
