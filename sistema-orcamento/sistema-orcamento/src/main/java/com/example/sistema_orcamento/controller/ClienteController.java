package com.example.sistema_orcamento.controller;

import com.example.sistema_orcamento.model.Cliente;
import com.example.sistema_orcamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Exibir lista de clientes
    @GetMapping
    public String listarTodos(Model model) {
        List<Cliente> listaClientes = clienteService.listarTodos();
        model.addAttribute("clientes", listaClientes);
        return "clientes/listar";
    }

    // Exibir cliente por ID
    @GetMapping("/{id_cliente}")
    public String buscarPorId(@PathVariable Long id_cliente, Model model) {
        Cliente cliente = clienteService.buscarPorId(id_cliente).orElse(null);
        model.addAttribute("cliente", cliente);
        return "clientes/detalhes";
    }

    // Salvar cliente
    @PostMapping
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/clientes";
    }

    // Excluir cliente
    @PostMapping("/{id_cliente}/excluir")
    public String excluir(@PathVariable Long id_cliente) {
        clienteService.excluir(id_cliente);
        return "redirect:/clientes";
    }

    // Editar cliente (GET)
    @GetMapping("/{id_cliente}/editar")
    public String editarCliente(@PathVariable("id_cliente") Long id_cliente, Model model) {
        // Buscar o cliente pelo ID
        Cliente cliente = clienteService.buscarPorId(id_cliente).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente); // Adicionar o cliente ao modelo
            return "clientes/editar"; // Nome da view HTML
        } else {
            return "redirect:/clientes"; // Redireciona para a lista de clientes caso não encontre o cliente
        }
    }

    // Atualizar cliente após edição (POST)
    @PostMapping("/{id_cliente}/editar")
    public String atualizar(@PathVariable Long id_cliente, @ModelAttribute Cliente cliente) {
        cliente.setId(id_cliente);  // Garantir que o ID está sendo mantido
        clienteService.salvar(cliente);  // Atualiza o cliente no banco de dados
        return "redirect:/clientes";  // Redireciona para a lista de clientes após atualização
    }

    // Exibir formulário de criação de novo cliente
    @GetMapping("/novo")
    public String novoCliente(Model model) {
        model.addAttribute("cliente", new Cliente()); // Formulário vazio para novo cliente
        return "clientes/novo";
    }
}
