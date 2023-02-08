package com.reynaldohendson.rhlog.repository;

import com.reynaldohendson.rhlog.dto.ClienteModel;
import com.reynaldohendson.rhlog.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<ClienteModel> findByNomeContains(String nome);
    Optional<Cliente> findByEmail(String email);
}
