package br.com.ghbalbuquerque.democleanarch.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO {

    private UUID id;

    private String name;

    private LocalDate birthdate;

}
