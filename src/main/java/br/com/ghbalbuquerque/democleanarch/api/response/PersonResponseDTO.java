package br.com.ghbalbuquerque.democleanarch.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PersonResponseDTO {

    private UUID id;

    private String name;

    private LocalDate birthdate;

}
