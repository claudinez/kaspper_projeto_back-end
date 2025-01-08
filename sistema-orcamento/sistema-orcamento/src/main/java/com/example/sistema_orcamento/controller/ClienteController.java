package com.example.sistema_orcamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sistema_orcamento.model.*;
import com.example.sistema_orcamento.service.ClienteService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.listarTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/listar"; // Template Thymeleaf para listar clientes
    }

    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/novo"; // Template para o formulário de cliente
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "clientes/editar";
        } else {
            return "redirect:/clientes";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable Long id) {
        clienteService.excluir(id);
        return "redirect:/clientes";
    }

    @GetMapping("/api")
    @ResponseBody
    public ResponseEntity<List<Cliente>> listarClientesAPI() {
        List<Cliente> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }
}