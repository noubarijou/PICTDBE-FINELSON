package com.alucar.domain.repository;

import com.alucar.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // define que é um repositório que gerencia a classe Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

      Optional<Cliente> findByEmail(String email);  // consulta Cliente por email para gerar a regra em service de não permitir cadastro de email duplicado

      @Query("SELECT e FROM Cliente e JOIN FETCH e.roles WHERE e.username = (:username)")
      public Cliente findByUsername(@Param("username") String username);

}

