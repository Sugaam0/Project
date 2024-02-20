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

@WebServlet("/NoteEditServlet")
public class NoteEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
			try {
				
				Integer noteid = Integer.parseInt(request.getParameter("noteid").trim());
				String Title = request.getParameter("title");
				String Content  = request.getParameter("content");
				
				postDAO dao = new postDAO(DBConnect.getConn());
				boolean f = dao.postUpdate(noteid, Title, Content);
				
				if(f)
				{
					System.out.println("data updated succesfully");
					HttpSession session = request.getSession();
					session.setAttribute("updateMsg", "Notes Updated Succesfully");
					response.sendRedirect("showNotes.jsp");
				}
				else
				{
					System.out.println("data not updated ");

				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
	}

}
