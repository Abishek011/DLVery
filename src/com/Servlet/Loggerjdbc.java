package com.Servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loggerjdbc")
public class Loggerjdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
        	String roll= request.getParameter("roll");
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/dlvery","raja","raja");
			String CREATE_TABLE=" CREATE TABLE IF NOT EXISTS logger ( team varchar(20) not null, time varchar(100))";
			Statement state=con.createStatement();
			state.executeUpdate(CREATE_TABLE);
			String logger="create table if not exists action_log(user_id varchar(200) not null, dated date not null, logger varchar(2000) not null, level varchar(200) not null, message varchar(2000) not null)";
			state.executeUpdate(logger);
			String insert="insert into logger values('"+
			        roll+"','"+new Timestamp(new Date().getTime()).toString()+"')";
			int res=state.executeUpdate(insert);
			if(res==0)
				throw new Exception();
			HttpSession session= request.getSession();
			session.setAttribute("team", roll);
			RequestDispatcher rs = request.getRequestDispatcher("log.jsp");
			rs.forward(request,response);
			} 
        catch (Exception e) {
        	response.getWriter().print("<script type=\"text/javascript\">window.alert('Error ...');location='index.html';</script>");
			e.printStackTrace();
		}
        
	}

}
