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
public class Categorias {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="categorias_id")
    private Integer categoriasId;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 15) //limita tamanho máximo de caracteres
    @Column(name="categorias_nome")
    private String categoriasNome;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 500) //limita tamanho máximo de caracteres
    @Column(name="url_img_modelo")
    private String urlImgModelo;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 500) //limita tamanho máximo de caracteres
    private String descricao;

    private double preco;

//    @OneToMany(mappedBy = "categorias", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("categorias")
//    @ToString.Exclude
//    private Set<Carro> carros = new HashSet<>();


}
