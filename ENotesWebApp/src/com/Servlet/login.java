package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/login")
public class login extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		
		UserDetails us = new UserDetails();
		us.setEmail(email);
		us.setPass(pass);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		UserDetails user = dao.login(us);
		if(user != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userD", user);
			
			response.sendRedirect("home.jsp");
		}else
		{
			HttpSession session = request.getSession();
			
			session.setAttribute("failed", "Invalid Username or Password!");
			response.sendRedirect("login.jsp");
		}
		
	}

}
