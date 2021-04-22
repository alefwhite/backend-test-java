package io.org.alefwhite.domains.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "empresas" )
@Getter
@Setter
public class Empresa implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "cnpj", length = 14, unique = true)
    private String cnpj;

    @Column(name = "telfone", length = 15)
    private String telfone;

    @Column(name = "qtd_vagas_motos")
    private Integer QtdagasMotos;

    @Column(name = "qtd_vagas_carros")
    private Integer QtdVagasCarros;

    @OneToMany( mappedBy = "empresa" , fetch = FetchType.LAZY )
    private Set<Usuario> usuarios;

    @OneToMany( mappedBy = "empresa" , fetch = FetchType.LAZY )
    private Set<Vaga> vagas;

}