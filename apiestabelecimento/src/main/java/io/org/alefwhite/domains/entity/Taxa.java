package io.org.alefwhite.domains.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table( name = "taxas")
@Getter
@Setter
public class Taxa implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column( name = "descricao")
    private String descricao;

    @Column( name = "tempo")
    private Integer tempo;

    @Column( name = "valor", precision = 20, scale = 2)
    private BigDecimal valor;

}
