package br.com.ghbalbuquerque.democleanarch.application.exception.custom;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomException;

public class CreateEntityException extends CustomException {

    public CreateEntityException(String code, String message) {
        super(code, message);
    }
}
