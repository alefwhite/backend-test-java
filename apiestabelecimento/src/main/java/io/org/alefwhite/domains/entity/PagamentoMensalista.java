package io.org.alefwhite.domains.entity;

import io.org.alefwhite.domains.enums.StausPagamento;
import io.org.alefwhite.domains.enums.TipoVeiculo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "pagamentos_mensalistas")
public class PagamentoMensalista implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "pagamento", columnDefinition = "boolean default false")
    private Boolean pagamento;

    @Column(name = "status_pagamento")
    @Enumerated(EnumType.STRING)
    private StausPagamento stausPagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
