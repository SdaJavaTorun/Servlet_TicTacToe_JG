package pl.sdaacademy;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String who = req.getParameter("who") != null ? req.getParameter("who") : getServletConfig().getInitParameter("who");
        out.print("<h1>Hello " + who + "!</h1>");

    }

}
