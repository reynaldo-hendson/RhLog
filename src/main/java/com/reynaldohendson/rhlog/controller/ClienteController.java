package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.dto.ClienteModel;
import com.reynaldohendson.rhlog.dto.EntregaModel;
import com.reynaldohendson.rhlog.mapper.ClienteMapper;
import com.reynaldohendson.rhlog.model.Cliente;
import com.reynaldohendson.rhlog.repository.ClienteRepository;
import com.reynaldohendson.rhlog.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/rhlog/")
@AllArgsConstructor
public class ClienteController {
    private ClienteService clienteService;
    private ClienteMapper clienteMapper;
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<ClienteModel> saveCliente(@RequestBody @Valid Cliente cliente){
        Cliente clienteCadastro = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteMapper.toModel(clienteCadastro));

    }
    @GetMapping("/clientes")
    public List<ClienteModel> listar(){
        return clienteMapper.toCollectionModel(clienteService.listar());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable ("id") Long id){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        return clienteOptional.<ResponseEntity<Object>>
                map(cliente -> ResponseEntity.status(HttpStatus.OK)
                .body(cliente))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Client not found."));
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable("id") @Valid Long id,@RequestBody Cliente cliente){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
        cliente.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable("id") Long id){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found.");
        }
        clienteService.delete(clienteOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client deleted successufully");
    }

}
