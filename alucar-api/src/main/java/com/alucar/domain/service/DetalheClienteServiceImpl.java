package com.alucar.domain.service;

import com.alucar.domain.data.DetalheClienteData;
import com.alucar.domain.model.Cliente;
import com.alucar.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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

//@Service
//@Transactional
//public class UserDetailsServiceImpl implements UserDetailsService {
//    @Autowired
//    ClienteRepository clienteRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        MyUser appUser = clienteRepository.findByEmail(username);
//
//        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
//
//        for (Role role: appUser.getRoles()) {
//            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
//            grantList.add(grantedAuthority);
//        }
//
//        UserDetails user = null;
//        user = (UserDetails) new User(username, appUser.getPassword(), grantList);
//        return user;
//    }
//}