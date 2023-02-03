package com.reynaldohendson.rhlog.service;


import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class OcorrenciaService {
    private BuscaEntregaService buscaEntregaService;
    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrenciaEntrega(descricao);
    }
}
