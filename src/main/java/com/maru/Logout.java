package com.maru;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cks = request.getCookies();
		
		if (cks != null) 
		{
			for (Cookie i: cks)
			{
				if (i.getName().equals("admin"))
				{
					i.setMaxAge(0);
					response.addCookie(i);
				}	
			}
		}
		
		response.sendRedirect("/loginp1/");
 	}

}
