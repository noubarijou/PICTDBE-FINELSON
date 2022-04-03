package com.alucar.domain.model.auth;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A autorização do perfil é necessária")
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Role.Authority authority;


    public String getAuthority() { return this.authority.name(); }

    public enum Authority {
        ADMIN, CLIENTE
    }
}
