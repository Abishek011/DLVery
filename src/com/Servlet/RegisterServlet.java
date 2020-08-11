package com.Servlet;

import java.io.IOException;



//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.Servlet.Register;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	static Logger log = Logger.getLogger(Registerjdbc.class);
	private static final long serialVersionUID = 1L;
	public void tableCheck(String team)
	{
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dlvery","raja","raja");
		String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+ team +"( username varchar(20) not null, dob varchar(20),email varchar(50),password varchar(20))";
		con.createStatement().executeUpdate(CREATE_TABLE);
		}
		catch(Exception e) {
			log.error("Error in Registeration of user");
			System.out.print("create error");
		}
	}
	public boolean validate(String s,String team)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dlvery","raja","raja");
            //System.out.print(employee.getUsername()+"hithere");
		String check = "select username from "+team+" where username=\'"+s+"\'";
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(check);
		while(set.next())
		{
			System.out.print(set.getString(1));
		}
		con.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in register"+team);
		}
		return false;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String dob= request.getParameter("dob");
		String password= request.getParameter("password");
		String email= request.getParameter("email");
		HttpSession session =request.getSession();
		String team=(String) session.getAttribute("team");
		Register employee=new Register();
		employee.setDob(dob);
		employee.setUsername(username);
		employee.setPassword(password);
		employee.setEmail(email);
		tableCheck(team);
		try {
			if(!validate(employee.getUsername(),team))
			{
				new Registerjdbc().Registerjd(employee,team);  
				response.getWriter().print("<script type=\"text/javascript\">window.alert('User Successfully registered ...');location='log.jsp';</script>");
			}
			else
			{
				response.getWriter().print("<script type=\"text/javascript\">window.alert('User already exist ...');location='log.jsp';</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		
	}

}
