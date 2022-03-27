package com.alucar.api.controller;

import com.alucar.domain.model.Pedido;
import com.alucar.domain.repository.PedidoRepository;
import com.alucar.domain.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", allowedHeaders = " ")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> buscar(@PathVariable Integer pedidoId) {
        Optional<Pedido> pedido = pedidoRepository.findById(pedidoId);
            if(pedido.isPresent()){
                return ResponseEntity.ok(pedido.get());
            }
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido adicionar (@Valid @RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @PutMapping("/{pedidoId}")
    public ResponseEntity<Pedido> atualizar (@PathVariable Integer pedidoId, @Valid @RequestBody Pedido pedido) {
        if (!pedidoRepository.existsById(pedidoId)) {
            return ResponseEntity.notFound().build();
        }

        pedido.setPedidoId(pedidoId);
        pedido = pedidoService.salvar(pedido);

        return ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{pedidoId}")
    public ResponseEntity<Void> excluir (@PathVariable Integer pedidoId) {
        if (!pedidoRepository.existsById(pedidoId)) {
            return ResponseEntity.notFound().build();
        }

        pedidoService.excluir(pedidoId);

        return ResponseEntity.noContent().build();
    }
}