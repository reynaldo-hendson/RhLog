package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.dto.DestinatarioModel;
import com.reynaldohendson.rhlog.dto.EntregaModel;
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
    public ResponseEntity<EntregaModel> buscar(@PathVariable("id") Long id){
        return entregaRepository.findById(id)
                .map(entrega -> {
                    EntregaModel entregaModel = new EntregaModel();
                    entregaModel.setId(entrega.getId());
                    entregaModel.setNomeCliente(entrega.getCliente().getNome());
                    entregaModel.setDestinatario(new DestinatarioModel());
                    entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
                    entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
                    entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
                    entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
                    entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
                    entregaModel.setTaxa(entrega.getTaxa());
                    entregaModel.setStatus(entrega.getStatus());
                    entregaModel.setDataPedido(entrega.getDataPedido());
                    entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());


                    return ResponseEntity.ok(entregaModel);
                })
                .orElse(ResponseEntity.notFound().build());
    }



}
