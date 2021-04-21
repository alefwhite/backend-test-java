package io.org.alefwhite.domains.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "vagas" )
public class Vaga implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "setor", length = 1)
    private char setor;

    @Column(name = "tipo_veiculo", length = 1)
    private char tipoVeiculo;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public char getSetor() {
        return setor;
    }

    public void setSetor(char setor) {
        this.setor = setor;
    }

    public char getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(char tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}