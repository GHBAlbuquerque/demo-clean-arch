package br.com.ghbalbuquerque.democleanarch.application.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {

    private String code;
    private String message;
    private String field;
    private Object attemptedValue;

}
