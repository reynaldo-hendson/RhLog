package com.reynaldohendson.rhlog.service;

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
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Iterable<Cliente> listar(){
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
