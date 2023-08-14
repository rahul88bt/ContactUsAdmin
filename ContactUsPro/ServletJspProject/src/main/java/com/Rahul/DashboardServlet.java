package com.Rahul;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDao dao=new RequestDao();
		ArrayList<Request> activeUser=dao.fetchActiveUser(true);
		ArrayList<Request> archiveUser=dao.fetchArchiveUser(false);
		request.setAttribute("activeUser",activeUser);
		request.setAttribute("archiveUser",archiveUser);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("dashboard.jsp");
		requestDispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		boolean status=Boolean.parseBoolean(request.getParameter("status"));
		RequestDao r=new RequestDao();
		r.changeStatus(id,status);
		response.sendRedirect("/ServletJspProject/DashboardServlet");
		
	}

}
