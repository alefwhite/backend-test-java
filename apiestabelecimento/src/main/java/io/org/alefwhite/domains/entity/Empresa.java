package io.org.alefwhite.domains.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "empresas" )
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
    @NotEmpty(message = "Campo CPNJ é obrigatório")
    @CNPJ( message = "Informe um CPNJ válido!")
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