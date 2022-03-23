package com.alucar.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Caracteristicas {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caracteristicas_id;


    private int qtde_porta;


    private int qtde_assento;


    private int ar_condicionado;

    @NotBlank
    @Size (max = 10)
    private String tipo_combustivel;

    @NotBlank
    @Size (max = 15)
    private String cambio;

    @NotBlank
    @Size (max = 20)
    private String motor;

    @NotBlank
    @Size (max = 15)
    private String cor;

    @OneToMany(mappedBy = "caracteristicas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("caracteristicas")
    @ToString.Exclude
    private Set<Carro> carros = new HashSet<>();
}
