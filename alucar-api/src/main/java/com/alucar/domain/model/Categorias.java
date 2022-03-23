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
public class Categorias {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categorias_id;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 15) //limita tamanho máximo de caracteres
    private String categorias_nome;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 500) //limita tamanho máximo de caracteres
    private String url_img_modelo;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 500) //limita tamanho máximo de caracteres
    private String descricao;

//    @OneToMany(mappedBy = "categorias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("categorias")
//    @ToString.Exclude
//    private Set<Carro> carros = new HashSet<>();
}
