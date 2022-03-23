package com.alucar.domain.exception;

public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NegocioException(String message) {  //contrutor criado para receber a mensagem e passar a mensagem para classe pai (RuntimeException)
        super(message);
    }
}
