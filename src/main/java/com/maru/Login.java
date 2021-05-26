package com.maru;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		System.out.println(request.getAttributeNames());
		
		if(uname.equals("admin") && pass.equals("password")) 
		{			
			Cookie ck = new Cookie(uname, "adpass123");
			response.addCookie(ck);
			
			response.sendRedirect("Home");
		}
		else
		{
			rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
			rd.forward(request, response);
		}
	}
}
