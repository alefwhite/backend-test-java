package io.org.alefwhite.domains.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "pagamentos_mensalistas")
public class PagamentoMensalista implements Serializable {
    private static final Integer serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "admin", columnDefinition = "boolean default false")
    private Boolean pago;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
