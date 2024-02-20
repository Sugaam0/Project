package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.DAO.UserDAO;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		String contact = request.getParameter("ucontact");
		
		UserDetails us = new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPass(pass);
		us.setContact(contact);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f = dao.addUser(us);
		HttpSession session;
		
		
		if(f)
		{
			 session = request.getSession();
			session.setAttribute("success", "Registration Successful!!");
			response.sendRedirect("register.jsp");
		}else 
		{
			session= request.getSession();
			session.setAttribute("failed","Something went wrong!!");
			response.sendRedirect("register.jsp");
		}
	}
}
