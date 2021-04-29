package io.org.alefwhite.domains.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "vagas" )
public class Vaga implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "setor", length = 1)
    private char setor;

    @Column(name = "tipo_veiculo", length = 1)
    private char tipoVeiculo;

//    @ManyToOne
//    @JoinColumn(name = "empresa_id")
//    private Empresa empresa;
}