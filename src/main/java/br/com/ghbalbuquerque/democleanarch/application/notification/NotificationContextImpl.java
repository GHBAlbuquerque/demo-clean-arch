package br.com.ghbalbuquerque.democleanarch.application.notification;

import br.com.ghbalbuquerque.democleanarch.application.notification.interfaces.NotificationContext;
import br.com.ghbalbuquerque.democleanarch.application.notification.model.Notification;
import br.com.ghbalbuquerque.democleanarch.application.notification.model.NotificationAbstract;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationContextImpl implements NotificationContext {

    private List<NotificationAbstract> notifications = new ArrayList<NotificationAbstract>();

    @Override
    public void addNotification(String key, String message) {
        this.notifications.add(new Notification(key, message));
    }

    @Override
    public void addNotification(NotificationAbstract notification) {
        this.notifications.add(notification);
    }

    @Override
    public void addNotifications(List<NotificationAbstract> notifications) {
        this.notifications.addAll(notifications);
    }

    @Override
    public boolean hasNotifications() {
        return !notifications.isEmpty();
    }

    @Override
    public List<NotificationAbstract> getNotifications() {
        return notifications;
    }

    @Override
    public void cleanNotifications() {
        this.notifications = new ArrayList<>();
    }
}
