package io.org.alefwhite.domains.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table( name = "clientes" )
public class Cliente implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty( message = "Campo nome é obrigatório")
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    @NotEmpty( message = "Campo cpf é obrigatório")
    @CPF(message = "Informe um CPF válido")
    private String cpf;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "mensalista", columnDefinition = "boolean default false")
    private Boolean mensalista;

    @Column(name = "dia_vencimento_mensalista")
    private Integer diaVencimentoMensalista;

    @OneToMany( mappedBy = "cliente" , fetch = FetchType.EAGER )
    private List<Veiculo> veiculos;

}
