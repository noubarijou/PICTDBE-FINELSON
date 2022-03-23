package com.alucar.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cidades {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cidades_id;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 30) //limita tamanho máximo de caracteres
    private String cidades_nome;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 30) //limita tamanho máximo de caracteres
    private String pais;
}
