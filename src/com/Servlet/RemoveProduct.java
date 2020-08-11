package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product_output")
public class RemoveProduct extends HttpServlet {
       	/**
	 * 
	 */
	private static final long serialVersionUID = 2526265459352056398L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		String name=request.getParameter("product_name");
       		try {
            	Class.forName("com.mysql.jdbc.Driver");
    			Connection con=DriverManager.getConnection(
    			        "jdbc:mysql://localhost:3306/dlvery","raja","raja");
    			String delete_TABLE="delete from product where product_name=\'"+name+"\'";
    			Statement state=con.createStatement();
    			int count=state.executeUpdate(delete_TABLE);
    			if((count>0))
    			{
					response.getWriter().print("<script type=\"text/javascript\">window.alert('Product Taken out for Delivery  ......');window.history.back();</script>");
    			}
    			else
    			{
					response.getWriter().print("<script type=\"text/javascript\">window.alert('Product not available  ......');window.history.back();</script>");
    			}
       		}
       		catch(Exception e)
       		{
       			e.printStackTrace();
				response.getWriter().print("<script type=\"text/javascript\">window.alert('Error  ......');location='log.jsp';</script>");

       		}
       	}

}
