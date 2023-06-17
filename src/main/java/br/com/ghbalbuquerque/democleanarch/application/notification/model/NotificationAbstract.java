package br.com.ghbalbuquerque.democleanarch.application.notification.model;

import lombok.Getter;

@Getter
public abstract class NotificationAbstract {

    private final String key;
    private final String message;

    public NotificationAbstract(String key, String message) {
        this.key = key;
        this.message = message;
    }
}
