package com.alucar.domain.service;


import com.alucar.domain.exception.NegocioException;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service // cria a classe com semântica de serviço, onde ocorrerão as regras de negócio
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional // Declara que esse método é executado dentro de uma transação, caso algo de errado todas as operações feitas dentro do banco de dados é descartado
    public Cliente salvar (Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()) // criação d emétodo para verificar se email já existe cadastrado ou não.
                .stream() // percorre todos os itens existentes
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente)); // compara todos os emails e retorna true ou false

        if(emailEmUso) { // caso emailEmUso esteja em uso (true)
            throw  new NegocioException("Já existe um cadastro com esse e-mail"); // Envias mensagem para classe NegocioException.
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir (Integer clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
