package com.reynaldohendson.rhlog.repository;

import com.reynaldohendson.rhlog.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(@Param(value = "nome")String nome);
}
