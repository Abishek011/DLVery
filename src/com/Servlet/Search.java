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
@WebServlet("/search_product")
public class Search extends HttpServlet {
	
	private static final long serialVersionUID = -4505886942357581389L;

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
					"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\r\n"
					+ "<title>Inventory</title>\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"show.css\">\r\n" + 
					"<script type=\"text/javascript\" src=\"show.js\"></script>"
					+ "</head>\r\n" + 
					"<body >\r\n" + 
					"<div class=\"form-group pull-right\">"
					+ "<input type=\"text\" class=\"form-control search form-control my-0 py-1 pl-3 purple-border\" type=\"text\" placeholder=\"Search something here...\" aria-label=\"Search\">"
					+ "</div>"
					+ "<a href=\"log.jsp\" class = \"gets btn btn-danger\" style=\"text-align: center;\" >Log Out</a>\r\n" + 
					" <div class=\"row py-5\">\r\n" + 
					"    <div class=\"col-lg-10 mx-auto\">\r\n" + 
					"      <div class=\"card rounded shadow border-0\">\r\n" + 
					"        <div class=\"card-body p-5 bg-white rounded\">\r\n" + 
					"          <div class=\"table-responsive\">\r\n" + 
					"            <table id=\"example\" style=\"width:100%\" class=\"table table-hover table-bordered results table table-striped table-bordered\">\r\n" + 
					"              <thead>\r\n" + 
					"                <tr>\r\n" + 
					"                            <th >No</th>\r\n" + 
					"                            <th >Product_name</th>\r\n" + 
					"                            <th >Category</th>\r\n" + 
					"                            <th > Product_condition</th>\r\n" + 
					"                            <th >Product_expdate</th>\r\n" + 
					"                            <th >Perishable</th>\r\n" + 
					"                            <th >Product_description</th>\r\n" + 
					"                </tr>\r\n" + 
					"              </thead>\r\n" + 
					"              <tbody>\r\n" + 
					"                <tr>\r\n" + 
					" " ;
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
					
					pre+="</tbody>\r\n" + 
							"            </table>\r\n" + 
							"          </div>\r\n" + 
							"        </div>\r\n" + 
							"      </div>\r\n" + 
							
							"    </div>\r\n" + 
							"  </div>\r\n" + 
							"</div>" + 
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
