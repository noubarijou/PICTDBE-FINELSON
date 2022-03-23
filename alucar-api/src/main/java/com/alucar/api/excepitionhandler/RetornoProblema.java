package com.alucar.api.excepitionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) // retira campos nulos no retorno.
@Getter
@Setter
public class RetornoProblema {

    private Integer status;
    private LocalDateTime dataHora;
    private String titulo;
    private List<Campo> campos; // cria uma lista de campos, chamando a classe Campo dentro do corpo(abaixo)

    @AllArgsConstructor
    @Getter
    public static class Campo {
        private String nome;
        private String mensagem;
    }

}
