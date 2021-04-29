package io.org.alefwhite.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "usuarios" )
public class Usuario implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "senha", length = 100)
    private String senha;

    @Column(name = "admin", columnDefinition = "boolean default false")
    private Boolean admin;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnore
    private Empresa empresa;
}
