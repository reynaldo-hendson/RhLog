package com.reynaldohendson.rhlog.mapper;

import com.reynaldohendson.rhlog.dto.OcorrenciaModel;
import com.reynaldohendson.rhlog.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;
    public OcorrenciaModel toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaModel.class);
    }
    /*
    * Retorna uma lista de ocorrencias model a partir de uma lista de ocorrencias*/
    public List<OcorrenciaModel> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());

    }

}
