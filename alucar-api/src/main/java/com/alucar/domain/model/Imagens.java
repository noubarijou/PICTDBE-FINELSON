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
public class Imagens {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imagens_id;

    @NotBlank
    @Size(max = 60)
    private String titulo;

    @NotBlank
    @Size (max = 500)
    private String url_imagem;

//    @OneToMany(mappedBy = "imagens", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("imagens")
//    @ToString.Exclude
//    private Set<Carro> carros = new HashSet<>();
}
