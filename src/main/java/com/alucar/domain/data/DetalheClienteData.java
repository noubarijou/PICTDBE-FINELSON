package com.alucar.domain.data;

import com.alucar.domain.model.Cliente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class DetalheClienteData implements UserDetails {

    private final Optional<Cliente> cliente;

    public DetalheClienteData(Optional<Cliente> cliente) { this.cliente = cliente; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return new ArrayList<>(); }

    @Override
    public String getPassword() { return cliente.orElse(new Cliente()).getSenha(); }

    @Override
    public String getUsername() { return cliente.orElse(new Cliente()).getEmail(); }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
