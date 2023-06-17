package br.com.ghbalbuquerque.democleanarch.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonUpdateDTO {

    @NotNull
    String name;

    @NotNull
    LocalDate brithdate;
}
