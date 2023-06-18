package br.com.ghbalbuquerque.democleanarch.application.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionDetails {

    private String type;
    private String title;
    private String code;
    private String detail;
    private Integer status;
    private Date date;
}