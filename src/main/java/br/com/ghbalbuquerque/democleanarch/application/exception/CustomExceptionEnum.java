package br.com.ghbalbuquerque.democleanarch.application.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomExceptionEnum {
    DCA1001("DCA-1001", "Person already registered on database."),
    DCA1002("DCA-1002", "Age below 18."),

    DCA2001("DCA-2001", "Error creating entity."),
    DCA2002("DCA-2002", "Entity not found.");

    private String code;
    private String message;

}
