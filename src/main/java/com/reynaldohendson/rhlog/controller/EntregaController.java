package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.dto.DestinatarioModel;
import com.reynaldohendson.rhlog.dto.EntregaModel;
import com.reynaldohendson.rhlog.mapper.EntregaMapper;
import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import com.reynaldohendson.rhlog.service.FinalizacaoEntregaService;
import com.reynaldohendson.rhlog.service.SolicitacaoEntregaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/rhlog/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;
    private FinalizacaoEntregaService finalizacaoEntregaService;

    @PostMapping
    public ResponseEntity<EntregaModel> solicitar(@RequestBody @Valid Entrega entrega){
        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(entrega);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(entregaMapper.toModel(entregaSolicitada));
    }

    @GetMapping
    public List<EntregaModel> listar(){
        return entregaMapper.toCollectionModel(solicitacaoEntregaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable("id") Long id){
        return entregaRepository.findById(id)
                .map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{entregaId}/finalizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long entregaId){
            finalizacaoEntregaService.finalizar(entregaId);
    }



}
