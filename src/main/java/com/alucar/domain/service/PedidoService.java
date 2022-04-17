package com.alucar.domain.service;

import com.alucar.domain.model.Pedido;
import com.alucar.domain.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public Pedido atualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public String excluir (Integer pedidoId) {
        pedidoRepository.deleteById(pedidoId);
        return "Pedido cancelado com sucesso.";
    }
}
