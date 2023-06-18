package br.com.ghbalbuquerque.democleanarch.api.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonUpdateDTO {

    String name;

    LocalDate birthdate;
}
