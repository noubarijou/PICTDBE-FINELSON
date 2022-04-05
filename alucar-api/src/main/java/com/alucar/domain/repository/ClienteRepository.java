package com.alucar.domain.repository;

import com.alucar.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // define que é um repositório que gerencia a classe Cliente
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

      public Optional<Cliente> findByEmail(String email);  // consulta Cliente por email para gerar a regra em service de não permitir cadastro de email duplicado
}
