package com.Servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.postDAO;
import com.db.DBConnect;
import com.User.post;




@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		postDAO dao = new postDAO(DBConnect.getConn());
		boolean f = dao.AddNotes(title, content, id);

		if (f) {
			System.out.println("data inserted succesfully");
			response.sendRedirect("showNotes.jsp");
		} else {
			System.out.println("data not Inserted  ");

		}
	}

}
