package com.alucar.api.excepitionhandler;

import com.alucar.domain.exception.NegocioException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice //propósito específico de tratar exceções de forma global
public class ApiExceptionHandler extends ResponseEntityExceptionHandler { // ResponseEntityExceptionHandler -> classe que já trata de várias exceptios

    private MessageSource messageSource; // interface para resolver mensagens padrões(criadas no message.properties)

    // substituição do retorno padrão para o erro handleMethodArgumentNotValid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<RetornoProblema.Campo> campos = new ArrayList<>(); // declaração de lista de campos

        for (ObjectError error : ex.getBindingResult().getAllErrors()) { //adicionando todos os possíveis erros em error
            String nome = ((FieldError)error).getField(); //pegando o nome do campo utilizando casting
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale()); // getMessage(pega primeiro o erro, determina a lingua e região)

            campos.add(new RetornoProblema.Campo(nome, mensagem));
        }

        RetornoProblema retornoProblema = new RetornoProblema();
        retornoProblema.setStatus(status.value()); // recebe o status da requisição e passa para o retornoProblema. .value() -> retorna um número inteiro
        retornoProblema.setDataHora(LocalDateTime.now()); // recebe a data e a hora que ocorreu
        retornoProblema.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        retornoProblema.setCampos(campos); // retorna a lista de campos

        return handleExceptionInternal(ex, retornoProblema, headers, status, request);
    }

    @ExceptionHandler(NegocioException.class) //caso a excessão NegocioException seja lançada em qualquer parte da aplicação, esse método é responsável por trata-la
    public ResponseEntity<Object> handleNegocioException(NegocioException ex, WebRequest request) { //método criado para tratar o retorno da classe NegocioException.  WebRequest -> retorno padrão do java para o request
        HttpStatus status = HttpStatus.BAD_REQUEST; // retorna o código de status 400

        RetornoProblema retornoProblema = new RetornoProblema();
        retornoProblema.setStatus(status.value()); // recebe o status da requisição e passa para o retornoProblema. .value() -> retorna um número inteiro
        retornoProblema.setDataHora(LocalDateTime.now()); // recebe a data e a hora que ocorreu
        retornoProblema.setTitulo(ex.getMessage()); //retorna a mensagem criada no ClienteService

        return handleExceptionInternal(ex, retornoProblema, new HttpHeaders(), status, request);
    }
}
