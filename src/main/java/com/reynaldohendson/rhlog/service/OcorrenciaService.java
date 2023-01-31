package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.exceptionHandler.NegocioException;
import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.model.Ocorrencia;
import com.reynaldohendson.rhlog.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {
    private EntregaRepository entregaRepository;
    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        // verificar se a entrega existe orElse.
        Entrega entrega = entregaRepository.findById(entregaId)
                .orElseThrow(()-> new NegocioException("Entrega não encontrada."));
        return entrega.adicionarEntregaDescricao(descricao);
    }
}
