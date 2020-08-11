package com.Servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowProduct
 */
@WebServlet("/show")
public class ShowProduct extends HttpServlet {
	
	private static final long serialVersionUID = -130899308425560784L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=(String)request.getParameter("using");
		//ArrayList<String> list=new ArrayList<>();
		try {
        	Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/dlvery","raja","raja");
			String select_TABLE="select * from product group by "+s;
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(select_TABLE);
			PrintWriter pl=response.getWriter();
			int count=1;
			response.setContentType("text/html");
			String pre=//"<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\r\n" + 
//					"    pageEncoding=\"ISO-8859-1\"%>\r\n" + 
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
					"	    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"><meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Inventory</title>\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"show.css\">\r\n" + 
					"</head>\r\n" + 
					"<body >\r\n" + 
					"<a href=\"log.jsp\" class = \"gets btn btn-danger\" style=\"text-align: center;\" >Log Out</a>\r\n" + 
					" <div class=\"container\">\r\n" + 
					"<section class=\"content-info\">\r\n" + 
					"    <div class=\"container paddings-mini\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"            <div class=\"col-lg-12\">\r\n" + 
					"                <table class=\"table-striped table-responsive table-hover result-point\">\r\n" + 
					"                    <thead class=\"point-table-head\">\r\n" + 
					"                        <tr>\r\n" + 
					"                            <th class=\"text-left\">No</th>\r\n" + 
					"                            <th class=\"text-left\">Product_name</th>\r\n" + 
					"                            <th class=\"text-center\">Category</th>\r\n" + 
					"                            <th class=\"text-center\"> Product_condition</th>\r\n" + 
					"                            <th class=\"text-center\">Product_expdate</th>\r\n" + 
					"                            <th class=\"text-center\">Perishable</th>\r\n" + 
					"                            <th class=\"text-center\">Product_description</th>\r\n" + 
					"                        </tr>\r\n" + 
					"                    </thead>\r\n" + 
					"                    <tbody class=\"text-center\">\r\n" + 
					"                        <tr>\r\n" ;
					while(rs.next())
					{
					pre+=" <tr>\r\n" + 
							"                            <td class=\"text-left number\">"+count+++" <i class=\"fa fa-caret-up\" aria-hidden=\"true\"></i></td>\r\n" +  
							"                            <td>"+rs.getString(1)+"</td>\r\n" + 
							"                            <td>"+rs.getString(2)+"</td>\r\n" + 
							"                            <td>"+rs.getString(3)+"</td>\r\n" + 
							"                            <td>"+rs.getString(4)+"</td>\r\n" + 
							"                            <td>"+rs.getString(5)+"</td>\r\n" + 
							"                            <td>"+rs.getString(6)+"</td>\r\n" +
							"                        </tr>";
					}
					
					pre+="                    </tbody>\r\n" + 
					"                </table>\r\n" + 
					"            </div>\r\n" + 
					"        </div>\r\n" + 
					"    </div>\r\n" + 
					"</section>\r\n" + 
					"    </div>\r\n" + 
					"</body>\r\n" + 
					"</html>";
					pl.print(pre);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
