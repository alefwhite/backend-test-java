package io.org.alefwhite.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "veiculos" )
public class Veiculo implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "tipo_veiculo", length = 1)
    private char tipoVeiculo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
