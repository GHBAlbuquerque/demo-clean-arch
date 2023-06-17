package br.com.ghbalbuquerque.democleanarch.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonCreationDTO {

    @NotNull
    String name;

    @NotNull
    LocalDate brithdate;
}
