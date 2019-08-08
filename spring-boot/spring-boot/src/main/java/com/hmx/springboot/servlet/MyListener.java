package com.hmx.springboot.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener(value = "listener")
public class MyListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext context = sre.getServletContext();
        context.log("servlet was been initialized");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletContext context = sre.getServletContext();
        context.log("servlet was been destroyed");
    }
}
