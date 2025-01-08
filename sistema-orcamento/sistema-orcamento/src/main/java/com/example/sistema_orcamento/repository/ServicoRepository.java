package com.example.sistema_orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sistema_orcamento.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
    // Métodos customizados podem ser adicionados aqui
}
