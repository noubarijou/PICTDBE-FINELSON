package com.alucar.domain.service;

import com.alucar.domain.data.DetalheClienteData;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheClienteServiceImpl implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    public DetalheClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isEmpty()) {
            throw new UsernameNotFoundException("Endereço de email [" + email + "] não localizado");
        }

        return new DetalheClienteData(cliente);
    }
}
