package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.exceptionHandler.NegocioException;
import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    /*Verifica se existe uma entrega, se não envia uma excption.*/
    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new NegocioException("Entrega não encontrada"));
    }

}
