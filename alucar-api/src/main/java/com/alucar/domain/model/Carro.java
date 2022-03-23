package com.alucar.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Carro {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carro_id;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 30) //limita tamanho máximo de caracteres
    private String modelo;

    private double valor;

    private int unid_disponiveis;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categorias categorias;

    @ManyToOne
    @JoinColumn(name = "caracteristicas_id")
    private Caracteristicas caracteristicas;

    @ManyToOne
    @JoinColumn(name = "imagens_id")
    private Imagens imagens;
}


