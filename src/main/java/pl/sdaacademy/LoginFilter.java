package pl.sdaacademy;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException{
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {

            String ipAddress = request.getRemoteAddr();
            System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());
            chain.doFilter(request, response);
    }

    public void destroy( ){}


}
