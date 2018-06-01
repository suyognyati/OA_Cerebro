package com.web.oauth2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.annotation.Configuration;

import com.web.staticandconstants.StaticConstants;

@Configuration
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created");
        event.getSession().setMaxInactiveInterval(StaticConstants.httpSessionTimeOut);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
       System.out.println("session destroyed");
    }
}
