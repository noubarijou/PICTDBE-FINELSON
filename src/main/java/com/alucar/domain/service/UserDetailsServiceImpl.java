package com.alucar.domain.service;

import com.alucar.domain.data.DetalheClienteData;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);

        if (cliente.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + email + "] não encontrado");
        }

        return new DetalheClienteData(cliente);
    }
}
