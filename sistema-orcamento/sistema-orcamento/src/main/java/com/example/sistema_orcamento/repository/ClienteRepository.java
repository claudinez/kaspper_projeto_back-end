package com.example.sistema_orcamento.repository;

import com.example.sistema_orcamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
