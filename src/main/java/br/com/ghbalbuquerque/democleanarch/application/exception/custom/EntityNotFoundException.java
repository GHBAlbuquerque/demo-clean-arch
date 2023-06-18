package br.com.ghbalbuquerque.democleanarch.application.exception.custom;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomException;

public class EntityNotFoundException extends CustomException {

    public EntityNotFoundException(String code, String message) {
        super(code, message);
    }
}
