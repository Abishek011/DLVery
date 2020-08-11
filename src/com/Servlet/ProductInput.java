package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductInput
 */
@WebServlet("/product_input")
public class ProductInput extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=(String)request.getParameter("Product_name");
		String category=(String)request.getParameter("category");
		String condition=(String)request.getParameter("condition");
		String expdate=(String)request.getParameter("expdate");
		String perishable=(String)request.getParameter("perishable");
		String description=(String)request.getParameter("description");
		try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/dlvery","raja","raja");
			String CREATE_TABLE=" CREATE TABLE IF NOT EXISTS product ( Product_name varchar(20) not null, category varchar(100),Product_condition varchar(100),Product_expdate varchar(100),Perishable varchar(100),Product_description varchar(100))";
			con.createStatement().executeUpdate(CREATE_TABLE);
			String INSERT_USERS_SQL = "INSERT INTO product"+
			        "  (Product_name,category,Product_condition,Product_expdate,Perishable,Product_description) VALUES " +
			        " (?, ?, ?, ?,?,?)";  
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
	            preparedStatement.setString(1,name);
	            preparedStatement.setString(2,category);
	            preparedStatement.setString(3,condition);
	            preparedStatement.setString(4,expdate);
	            preparedStatement.setString(5,perishable);
	            preparedStatement.setString(6,description);
	            preparedStatement.executeUpdate(); 
	            con.close();
	            response.getWriter().print("<script type=\"text/javascript\">window.alert('Product Successfully added to Inventory ......');location='inventory.jsp';</script>");
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

}
