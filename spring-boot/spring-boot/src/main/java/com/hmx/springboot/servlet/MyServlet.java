package com.hmx.springboot.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "myServlet",
        urlPatterns = "/hello",
        initParams = {@WebInitParam(name = "myName",value = "myValue")})
public class MyServlet extends HttpServlet {

    public String value;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        value = servletConfig.getInitParameter("myName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        ServletContext context = req.getServletContext();
        context.log("servlet do Get");
        writer.write(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
