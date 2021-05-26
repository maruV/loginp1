package com.maru;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/About")
public class About extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher rd;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		rd = request.getRequestDispatcher("/WEB-INF/about.jsp");
		
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
		
		rd.forward(request, response);
	}
}