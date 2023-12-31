package br.com.ghbalbuquerque.democleanarch.application.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends Exception {

    private final String code;

    public CustomException(String code, String message) {
        super(message);
        this.code = code;
    }
}
