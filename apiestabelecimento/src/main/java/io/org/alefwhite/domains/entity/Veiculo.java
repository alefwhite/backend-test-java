package io.org.alefwhite.domains.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "veiculos" )
public class Veiculo implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "marca", length = 100)
    private String marca;

    @Column(name = "cor", length = 100)
    private String cor;

    @Column(name = "placa", length = 7)
    private String placa;

    @Column(name = "tipo_veiculo", length = 1)
    private char tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public char getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(char tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
