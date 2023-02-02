package com.reynaldohendson.rhlog.mapper;

import com.reynaldohendson.rhlog.dto.ClienteModel;
import com.reynaldohendson.rhlog.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Component
public class ClienteMapper {
    private ModelMapper modelMapper;

    public ClienteModel toModel(Cliente cliente){
        return modelMapper.map(cliente,ClienteModel.class);
    }

    public List<ClienteModel> toCollectionModel(List<Cliente> clientes){
        return clientes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
