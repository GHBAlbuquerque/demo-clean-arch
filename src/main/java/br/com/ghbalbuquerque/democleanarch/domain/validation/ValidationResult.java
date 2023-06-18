package br.com.ghbalbuquerque.democleanarch.domain.validation;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomError;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationResult {

    private Boolean isValid;
    private List<CustomError> errors = new ArrayList<>();

}
