package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.postDAO;
import com.db.DBConnect;


@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer noteid = Integer.parseInt(request.getParameter("notes_id"));
		postDAO dao = new postDAO(DBConnect.getConn());
		
		boolean f = dao.DeleteNotes(noteid);
		HttpSession session = null;
		if(f)
		{
			session =request.getSession();
			session.setAttribute("updateMsg", "Note Deleted Succesfully");
			response.sendRedirect("showNotes.jsp");
		}
		else {
			session = request.getSession();
			session.setAttribute("wrongMsg", "Something went wrong");
			response.sendRedirect("showNotes.jsp");
		}
		
	}

}
