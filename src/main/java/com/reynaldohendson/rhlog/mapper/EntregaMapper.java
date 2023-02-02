package com.reynaldohendson.rhlog.mapper;

import com.reynaldohendson.rhlog.dto.EntregaModel;
import com.reynaldohendson.rhlog.model.Entrega;
import com.reynaldohendson.rhlog.model.input.EntregaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Component
public class EntregaMapper {

    //Classe de conversao da entidade entrega.
    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    //.stream(), retorna um fluxo que é uma sequencia de elementos de agregação.
    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                //converte uma stream de entregas para entregasModel
                .map(this::toModel)
                .collect(Collectors.toList());

    }

    // converte a classe input para a entidade entrega
    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }


}
