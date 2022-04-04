package com.alucar.domain.model;

import jdk.jfr.Enabled;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true) // verifica a igualdade de dois objetos, com a inclusão dos parenteses, temmos a comparação através de um campo determinado deforma explicita
@Getter
@Setter
@Entity // define a classe como uma entidade, ou seja, uma tabela no banco de dados
@Table(name="cliente") // pode ser usado para nomear a tabela do BD da maneira que preferir, se não for usado, pega o próprio nome da classe
public class Cliente {

    @EqualsAndHashCode.Include // determina o campo id como fator de comparação explicitamente
    @Id //define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cliente_id")
    private Integer clienteId;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 30) //limita tamanho máximo de caracteres
    @Column(name="cliente_nome")
    private String clienteNome;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 30) //limita tamanho máximo de caracteres
    @Column(name="cliente_sobrenome")
    private String clienteSobrenome;

    @NotBlank
    @Email // valida email válido (sintaxe correta)
    @Size (max = 255)
    private String email;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 20) //limita tamanhop máximo de caracteres
    private String telefone;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 10) //limita tamanhop máximo de caracteres
    @Column(name="data_nascimento")
    private String dataNascimento;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 15) //limita tamanhop máximo de caracteres
    private String cpf;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 20) //limita tamanhop máximo de caracteres
    private String cnh;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 100) //limita tamanhop máximo de caracteres
    private String senha;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColums = @JoinColumn(name = "cliente_id"))
    @Column(name = "funcao_id")
    private List<String> funcao = new ArrayList<>();

    public Cliente() { }

    public Cliente(String username) {
        this.email = username;
    }


//    @Override
//    public String getPassword() { return senha; }
//
//    @Override
//    public String getUsername() { return email; }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(funcao.name());
//        return Collections.singletonList(grantedAuthority);
//    }
//
//    @Override
//    public boolean isAccountNonExpired() { return true; }
//
//    @Override
//    public boolean isAccountNonLocked() { return true; }
//
//    @Override
//    public boolean isCredentialNonExpired() { return true; }
//
//    @Override
//    public boolean isEnabled() { return true; }
}
