package com.maru;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = {"Home", "About"})
public class Islogged implements Filter {
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
        
        Cookie[] cookies = req.getCookies();
        
        if (cookies != null)
        {
          for (Cookie ck : cookies) 
          {
            if ("admin".equals(ck.getName()) && "adpass123".equals(ck.getValue()) ) 
            {
               	chain.doFilter(request, response);
            }
          }
          res.sendRedirect("Login");
        }
        else
        {        	
        	res.sendRedirect("Login");
        }
	}
}