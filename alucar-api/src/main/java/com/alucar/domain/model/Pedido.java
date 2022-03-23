package com.alucar.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pedido_id;


    private LocalDateTime data_retirada;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size(max = 15) //limita tamanhop máximo de caracteres
    private String horario_retirada;


    private LocalDateTime data_entrega;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 15) //limita tamanhop máximo de caracteres
    private String horario_entrega;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 60) //limita tamanhop máximo de caracteres
    private String local_retirada;

    @NotBlank // impede que seja passado campo em branco ou nulo
    @Size (max = 60) //limita tamanhop máximo de caracteres
    private String local_entrega;

    @ManyToOne
    //@JoinColumn(name = "cliente_id") // anotação para determinar o nome da coluna no BD, caso não colocado, assumi o default ("classe"_id)
    private Cliente cliente;

    @ManyToOne
    private Cidades cidades;

    @ManyToOne
    private Carro carro;
}
