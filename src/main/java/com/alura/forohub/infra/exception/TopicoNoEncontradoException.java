package com.alura.forohub.infra.exception;

public class TopicoNoEncontradoException extends RuntimeException {

    public TopicoNoEncontradoException(String message) {
        super(message);
    }

    // Opcional: constructor sin parámetros
    public TopicoNoEncontradoException() {
        super("Tópico no encontrado");
    }
}