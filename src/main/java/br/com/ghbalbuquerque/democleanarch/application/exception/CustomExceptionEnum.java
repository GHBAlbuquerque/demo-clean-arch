package br.com.ghbalbuquerque.democleanarch.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomExceptionEnum {
    P0001("DCA-1001", "Person already registered on database."),
    P0002("DCA-1002", "Person not found.");

    private String code;
    private String message;

}
