package com.alucar.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size (max = 60) //limita tamanho máximo de caracteres
    @Column(name="cliente_nome")
    private String clienteNome;

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
    @Size (max = 15) //limita tamanhop máximo de caracteres
    private String senha;

    @NotBlank
    @Size (max = 30)
    private String funcao;

}
