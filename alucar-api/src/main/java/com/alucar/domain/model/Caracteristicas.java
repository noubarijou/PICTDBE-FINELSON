package com.alucar.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Caracteristicas {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="caracteristicas_id")
    private Integer caracteristicasId;

    @Column(name="qtde_porta")
    private int qtdePorta;

    @Column(name="qtde_assento")
    private int qtdeAssento;

    @Column(name="ar_condicionado")
    private int arCondicionado;

    @NotBlank
    @Size (max = 10)
    @Column(name="tipo_combustivel")
    private String tipoCombustivel;

    @NotBlank
    @Size (max = 15)
    private String cambio;

    @NotBlank
    @Size (max = 20)
    private String motor;

    @NotBlank
    @Size (max = 15)
    private String cor;



}
