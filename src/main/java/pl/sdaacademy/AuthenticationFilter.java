package pl.sdaacademy;


import javax.servlet.*;
import java.io.PrintWriter;
import java.util.Date;

public class AuthenticationFilter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

        String ipAddress = request.getRemoteAddr();
        System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
        if (ipAddress.equals("127.0. 0.1")) {
            chain.doFilter(request, response);
        }
        else {
            PrintWriter out = response.getWriter();
            out.print (" ERROR ");
        }
    }

    public void destroy( ){}


}

