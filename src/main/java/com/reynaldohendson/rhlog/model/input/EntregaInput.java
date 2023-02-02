package com.reynaldohendson.rhlog.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaInput {
    @Valid
    @NotNull
    private ClientIdInput cliente;
    @Valid
    @NotNull
    private DestinarioInput destinatario;
    @NotNull
    private BigDecimal taxa;


}
