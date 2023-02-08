package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public void finalizar(Long entregaId){
        //Verificar se a entrega existe, se não lança uma exception.
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
