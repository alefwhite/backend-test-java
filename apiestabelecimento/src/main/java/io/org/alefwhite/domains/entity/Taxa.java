package io.org.alefwhite.domains.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "taxas")
public class Taxa implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column( name = "descricao")
    private String descricao;

    @Column( name = "tempo")
    private Integer tempo;

    @Column( name = "valor", precision = 20, scale = 2)
    private BigDecimal valor;

}
