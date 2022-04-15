package com.alucar.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name="cidades_id")
    private Integer cidadesId;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 30) //limita tamanho máximo de caracteres
    @Column(name="cidades_nome")
    private String cidadesNome;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 2) //limita tamanho máximo de caracteres
    private String estado;
}
