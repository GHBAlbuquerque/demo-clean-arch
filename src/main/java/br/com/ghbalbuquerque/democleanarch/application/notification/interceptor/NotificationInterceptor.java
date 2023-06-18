package br.com.ghbalbuquerque.democleanarch.application.notification.interceptor;

import br.com.ghbalbuquerque.democleanarch.application.notification.interfaces.NotificationContext;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class NotificationInterceptor implements HandlerInterceptor {

    @Autowired
    public NotificationContext notificationContext;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

        if (notificationContext.hasNotifications()) {
            response.setStatus(400);
            var notificationJson = new Gson().toJson(notificationContext.getNotifications());
            response.getWriter().write(notificationJson);
            response.setContentType("application/json");
        }
    }
}
