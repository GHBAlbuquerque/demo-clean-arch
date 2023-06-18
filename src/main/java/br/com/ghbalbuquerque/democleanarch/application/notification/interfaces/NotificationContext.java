package br.com.ghbalbuquerque.democleanarch.application.notification.interfaces;


import br.com.ghbalbuquerque.democleanarch.application.notification.model.NotificationAbstract;

import java.util.List;

public interface NotificationContext {

    void addNotification(String key, String message);

    void addNotification(NotificationAbstract notification);

    void addNotifications(List<NotificationAbstract> notifications);

    boolean hasNotifications();

    List<NotificationAbstract> getNotifications();

    void cleanNotifications();
}
