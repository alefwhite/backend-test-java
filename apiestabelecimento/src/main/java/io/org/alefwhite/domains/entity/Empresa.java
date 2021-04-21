package io.org.alefwhite.domains.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelfone() {
        return telfone;
    }

    public void setTelfone(String telfone) {
        this.telfone = telfone;
    }

    public Integer getQtdagasMotos() {
        return QtdagasMotos;
    }

    public void setQtdagasMotos(Integer qtdagasMotos) {
        QtdagasMotos = qtdagasMotos;
    }

    public Integer getQtdVagasCarros() {
        return QtdVagasCarros;
    }

    public void setQtdVagasCarros(Integer qtdVagasCarros) {
        QtdVagasCarros = qtdVagasCarros;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}