package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.service.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/rhlog/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;
    @PostMapping
    public ResponseEntity<Entrega> solicitar(@RequestBody @Valid Entrega entrega){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(solicitacaoEntregaService.solicitar(entrega));
    }


}
