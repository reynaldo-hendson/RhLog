package com.reynaldohendson.rhlog.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    private Destinatario destinatario;
    private BigDecimal taxa;
    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
}
