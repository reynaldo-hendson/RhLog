package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import com.reynaldohendson.rhlog.service.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rhlog/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    @PostMapping
    public ResponseEntity<Entrega> solicitar(@RequestBody @Valid Entrega entrega){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(solicitacaoEntregaService.solicitar(entrega));
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscar(@PathVariable("id") Long id){
        return entregaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



}
