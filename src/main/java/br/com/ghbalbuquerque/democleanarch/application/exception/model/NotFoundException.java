package br.com.ghbalbuquerque.democleanarch.application.exception.model;

public class NotFoundException extends CustomException {

    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
