package br.com.ghbalbuquerque.democleanarch.application.exception.custom;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomException;

public class NotFoundException extends CustomException {

    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
