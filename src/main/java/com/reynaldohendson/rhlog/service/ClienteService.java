package com.reynaldohendson.rhlog.service;

import com.reynaldohendson.rhlog.exceptionHandler.NegocioException;
import com.reynaldohendson.rhlog.model.Cliente;
import com.reynaldohendson.rhlog.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {

    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public Cliente buscar(Long id){
        return  //Exception caso não exista o cliente cadastrado.
                 clienteRepository.findById(id)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado."));

    }

    @Transactional
    public Cliente save(Cliente cliente) {
        //Garante que um @, não seja cadastrado 2 vezes
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new NegocioException("Email já consta na base de dados. Cadastre outro email.");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public List<Cliente> findByNome(String nome){
        return clienteRepository.findByNome(nome);
    }

    public Optional<Cliente> findById(Long id){
        return clienteRepository.findById(id);
    }

    @Transactional
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
