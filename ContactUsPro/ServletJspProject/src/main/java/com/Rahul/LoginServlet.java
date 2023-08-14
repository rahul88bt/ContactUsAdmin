package com.Rahul;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		PrintWriter out=response.getWriter();
		UserDao userDao=new UserDao();
		User user=new User();
		user.setUser(username);
		user.setPass(pass);
		if(userDao.isValidUser(user)) {
			//out.println("Login Successfully");
			response.sendRedirect("/ServletJspProject/DashboardServlet");
			/*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletJspProject/DashboardServlet");
			requestDispatcher.forward(request, response);*/
		}
		else {
			out.println("Invalid User..");
		}
		
		
		
	}


}
