package com.reynaldohendson.rhlog.dto;

import com.reynaldohendson.rhlog.model.ClienteResumoModel;
import com.reynaldohendson.rhlog.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Getter
@Setter
public class EntregaModel {
    private long id;
    private ClienteResumoModel cliente;
    private DestinatarioModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

}
