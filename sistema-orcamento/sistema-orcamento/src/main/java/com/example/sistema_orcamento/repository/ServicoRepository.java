package com.example.sistema_orcamento.repository;

import com.example.sistema_orcamento.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
	
}
