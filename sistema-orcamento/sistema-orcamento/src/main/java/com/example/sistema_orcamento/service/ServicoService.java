package com.example.sistema_orcamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_orcamento.model.Servico;
import com.example.sistema_orcamento.repository.ServicoRepository;

@Service
public class ServicoService {
    // Lógica do servico
	 @Autowired
	 
	    private ServicoRepository servicoRepository;

	    public List <Servico> listarTodos() {
	        return servicoRepository.findAll();
	    }

	    public Optional<Servico> buscarPorId(Long id) {
	        return servicoRepository.findById(id);
	    }

	    public Servico salvar(Servico servico) {
	        return servicoRepository.save(servico);
	    }

	    public void excluir(Long id) {
	    	servicoRepository.deleteById(id);
	    }
}