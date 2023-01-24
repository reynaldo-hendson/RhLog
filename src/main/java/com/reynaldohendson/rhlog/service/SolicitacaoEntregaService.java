package com.reynaldohendson.rhlog.service;


import com.reynaldohendson.rhlog.model.Cliente;
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
    private ClienteService clienteService;
    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());

        //Retorna os dados dos clientes.
        entrega.setCliente(cliente);

        //Atribui automaticamente o status e data.
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);

    }
}
