package br.com.ghbalbuquerque.democleanarch.application.exception.model;

import br.com.ghbalbuquerque.democleanarch.application.notification.model.NotificationAbstract;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ExceptionDetails {

    private String type;

    private String title;

    private String code;

    private String detail;

    private Integer status;

    private Date date;

    private List<NotificationAbstract> errors;
}
