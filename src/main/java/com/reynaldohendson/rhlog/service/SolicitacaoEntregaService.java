package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.model.StatusEntrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {
    private EntregaRepository entregaRepository;
    @Transactional
    public Entrega solicitar(Entrega entrega){
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);

    }
}
