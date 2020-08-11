package com.Servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String Username=request.getParameter("userid");
			String Password=request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlvery","raja","raja");
	            HttpSession session=request.getSession();
	            String team=(String) session.getAttribute("team");
			String check = "select password from "+team+" where username=\'" +Username+"\'";
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(check);
//			HttpSession session=request.getSession();
			session.setAttribute("User", true);
			res.next();
			try {
			if(  res.getString(1).equals(Password))
				{
				if(team.equals("inventory_team"))
					response.sendRedirect("inventory.jsp");
				else if(team.equals("delivery_team"))
					{
					RequestDispatcher rd = request.getRequestDispatcher("/delivery");
					rd.forward(request,response);
					response.getWriter().print("hi");
					}
				}
				else
				{
					response.getWriter().print("<script type=\"text/javascript\">window.alert('Username/password is Incorrect or check Team selection  ......');location='log.jsp';</script>");
				}
			}
			catch(Exception e)
			{
				response.getWriter().print("<script type=\"text/javascript\">window.alert('Username/password is Incorrect ......');location='log.jsp';</script>");
			}
			con.close();
			} catch (Exception e) {
				response.getWriter().print("<script type=\"text/javascript\">window.alert('Error ...');location='index.jsp';</script>");
				e.printStackTrace();
			}  
	        
	}

}
