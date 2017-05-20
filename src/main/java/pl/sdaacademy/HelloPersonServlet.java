package pl.sdaacademy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloPersonServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.print(" <form type='post'> ");
        out.print(" <div> login: <input type='tekst' name='login' value'' /> </div>");
        out.print("  <div> <input type='submit' value='ZALOGUJ SIE' /> </div> ");

        String name = req.getParameter("login");
        out.print("Twoj login to " + name);

    }
}
