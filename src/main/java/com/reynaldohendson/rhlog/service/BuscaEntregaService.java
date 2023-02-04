package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.exceptionHandler.EntidadeNaoEncontradaException;
import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    /*Verifica se existe uma entrega, se não existir envia uma exception.*/
    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada"));
    }

}
