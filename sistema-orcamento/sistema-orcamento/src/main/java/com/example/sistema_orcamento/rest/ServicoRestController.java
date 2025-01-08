package com.example.sistema_orcamento.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sistema_orcamento.model.Servico;
import com.example.sistema_orcamento.repository.ClienteRepository;
import com.example.sistema_orcamento.repository.ServicoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = "*")
public class ServicoRestController {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarServico(@PathVariable Long id) {
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Servico> criarServico(@RequestBody Servico servico) {
        if (servico.getCliente() == null || !clienteRepository.existsById(servico.getCliente().getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Servico novoServico = servicoRepository.save(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizarServico(@PathVariable Long id, @RequestBody Servico servico) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        if (servico.getCliente() == null || !clienteRepository.existsById(servico.getCliente().getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        servico.setId(id);
        Servico servicoAtualizado = servicoRepository.save(servico);
        return ResponseEntity.ok(servicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        if (!servicoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        servicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
