package com.hmx.springboot.springboot_api;



import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class MyServlet2 extends HttpServlet {

    public String value;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        value = servletConfig.getInitParameter("myName");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();
        ServletContext context = req.getServletContext();
        context.log("servlet2 do Get");
        writer.write(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
