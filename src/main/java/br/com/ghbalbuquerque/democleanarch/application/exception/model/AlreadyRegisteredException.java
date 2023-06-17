package br.com.ghbalbuquerque.democleanarch.application.exception.model;

public class AlreadyRegisteredException extends CustomException {

    public AlreadyRegisteredException(String code, String message) {
        super(code, message);
    }
}
