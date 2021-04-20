package io.org.alefwhite.domains.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table( name = "taxas")
public class Taxa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column( name = "descricao")
    private String descricao;

    @Column( name = "tempo")
    private Integer tempo;

    @Column( name = "valor", precision = 20, scale = 2)
    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTempo() {
        return tempo;
    }

    public void setTempo(Integer tempo) {
        this.tempo = tempo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
