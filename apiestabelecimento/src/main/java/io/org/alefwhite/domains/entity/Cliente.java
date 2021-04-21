package io.org.alefwhite.domains.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "clientes" )
public class Cliente implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "mensalista", columnDefinition = "boolean default false")
    private Boolean mensalista;

    @Column(name = "dia_vencimento_mensalista")
    private Integer diaVencimentoMensalista;

    @JsonIgnore
    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<Veiculo> veiculos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getMensalista() {
        return mensalista;
    }

    public void setMensalista(Boolean mensalista) {
        this.mensalista = mensalista;
    }

    public Integer getDiaVencimentoMensalista() {
        return diaVencimentoMensalista;
    }

    public void setDiaVencimentoMensalista(Integer diaVencimentoMensalista) {
        this.diaVencimentoMensalista = diaVencimentoMensalista;
    }

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
