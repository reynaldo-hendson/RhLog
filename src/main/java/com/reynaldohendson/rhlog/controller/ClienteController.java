package com.reynaldohendson.rhlog.controller;

import com.reynaldohendson.rhlog.model.Cliente;
import com.reynaldohendson.rhlog.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/rhlog/")
public class ClienteController {
    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@RequestBody @Valid Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));

    }
    @GetMapping("/clientes")
    public Iterable<Cliente> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar()).getBody();
    }

    @GetMapping("/clientes/{nome}")
    public List<Cliente> findByNome(@PathVariable("nome")String nome){
        return clienteService.findByNome(nome);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable ("id") Long id){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteOptional.get());
    }

    @PutMapping("cliente/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable("id") @Valid Long id,@RequestBody Cliente cliente){
        Optional<Cliente> clienteOptional = clienteService.findById(id);
        if(!clienteOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente not found.");
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
