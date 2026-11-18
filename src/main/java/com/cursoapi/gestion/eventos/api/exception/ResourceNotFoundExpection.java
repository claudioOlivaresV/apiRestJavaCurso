package com.cursoapi.gestion.eventos.api.exception;

public class ResourceNotFoundExpection extends RuntimeException {
    public ResourceNotFoundExpection(String message) {
        super(message);
    }
}
