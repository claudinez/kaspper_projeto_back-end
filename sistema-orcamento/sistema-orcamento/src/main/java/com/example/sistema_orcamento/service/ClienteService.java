package com.example.sistema_orcamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistema_orcamento.model.Cliente;
import com.example.sistema_orcamento.repository.ClienteRepository;

@Service
public class ClienteService {
    // Lógica do serviço
	 @Autowired
	    private ClienteRepository clienteRepository;

	    public List<Cliente> listarTodos() {
	        return clienteRepository.findAll();
	    }

	    public Optional<Cliente> buscarPorId(Long id) {
	        return clienteRepository.findById(id);
	    }

	    public Cliente salvar(Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }

	    public void excluir(Long id) {
	        clienteRepository.deleteById(id);
	    }
}