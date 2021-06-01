package com.maru;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		AppInfo app = new AppInfo();
		try
		{
			String rName = request.getParameter("uname");
			String rPass = request.getParameter("pass");
		
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(app.getdburl(), app.getdbuname(), app.getdbpass());
	
			String query = "select uname from user where uname == " + rName + " and upass ==" + rPass;
	
			Statement s1 = conn.createStatement();
			ResultSet r1 = s1.executeQuery(query);
			
			if(r1.next() == true) 
			{		
				r1.next();
				String dbuname = r1.getString("uname");
				
				Cookie ck = new Cookie(dbuname, "adpass123");
				
				response.addCookie(ck);
				
				response.sendRedirect("Home");
			}
			else
			{
				rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
				rd.forward(request, response);
			}
			
			s1.close();
			conn.close();
		}
		catch (ClassNotFoundException cn)
		{
			cn.printStackTrace();
		}
		catch (SQLException se)
		{
			se.printStackTrace();
		}
	}
}
