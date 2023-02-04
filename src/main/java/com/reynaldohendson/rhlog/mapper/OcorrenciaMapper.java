package com.reynaldohendson.rhlog.mapper;

import com.reynaldohendson.rhlog.dto.OcorrenciaModel;
import com.reynaldohendson.rhlog.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;
    public OcorrenciaModel toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia,OcorrenciaModel.class);
    }

}
