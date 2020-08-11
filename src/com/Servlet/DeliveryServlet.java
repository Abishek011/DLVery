package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeliveryServlet
 */
@WebServlet("/delivery")
public class DeliveryServlet extends HttpServlet {
	
       	/**
	 * 
	 */
	private static final long serialVersionUID = -5702196324627878247L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       		try {
            	Class.forName("com.mysql.jdbc.Driver");
    			Connection con=DriverManager.getConnection(
    			        "jdbc:mysql://localhost:3306/dlvery","raja","raja");
    			String select_TABLE="select product_name from product group by product_expdate";
    			Statement state=con.createStatement();
    			ResultSet rs=state.executeQuery(select_TABLE);
    			PrintWriter pl=response.getWriter();
    			response.setContentType("text/html");
    			String pre="<!DOCTYPE html>\r\n" + 
    					"<html>\r\n" + 
    					"<head>\r\n" + 
    					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
    					"	    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
    					"        \r\n" + 
    					"<meta charset=\"ISO-8859-1\">\r\n" + 
    					"<title>Delivery</title>\r\n" + 
    					"<link rel=\"stylesheet\" type=\"text/css\" href=\"delivery.css\">\r\n" + 
    					"<link href=\"https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css\" rel=\"stylesheet\" >\r\n" + 
    					"<script src=\"https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js\"></script>\r\n" + 
    					"<script type=\"text/javascript\" >\r\n" + 
    					"$(\".js-example-tags\").select({\r\n" + 
    					"	  tags: true\r\n" + 
    					"	});\r\n" + 
    					"</script>\r\n" + 
    					"</head>\r\n" + 
    					"<body >\r\n" + 
    					"	<a href=\"log.jsp\" class = \"gets btn btn-danger\" style=\"text-align: center;\" >Log Out</a>\r\n" + 
    					" <div class=\"container\">\r\n" + 
    					"        <nav class=\"menu navbar navbar-default\">\r\n" + 
    					"            <ul class=\"main-menu\">\r\n" + 
    					"                <li class=\"active\"><i class=\"fa fa-home\"></i>Delivery</li>\r\n" + 
    					"                <li class=\"with-submenu\">\r\n" + 
    					"     \r\n" + 
    					"<!--                     <button onclick=\"location.href = 'show.jsp';\" style=\"color: white\" class=\"fa fa-briefcase\">Show-by</button><i class=\"fa fa-caret-down\"></i> -->\r\n" + 
    					"                     <form action=\"show\" method=\"post\">\r\n" + 
    					"                     <div class=\"box\">\r\n" + 
    					"						  <select name=\"using\" onchange=\"this.form.submit()\">\r\n" + 
    					"						  	<option value=\"\" class=\"fa fa-briefcase\">Show-by</option>\r\n" + 
    					"						    <option value=\"category\">Product Category</option>\r\n" + 
    					"						    <option value=\"Product_condition\">Condition</option>\r\n" + 
    					"<!-- 						    <option value=\"notdamaged\">Not Damaged</option> -->\r\n" + 
    					"						    <option value=\"Perishable\">Perishable</option>\r\n" + 
    					"						    <option value=\"Product_expdate\">Expiry Data</option>\r\n" + 
    					"						  </select>\r\n" + 
    					"					</div>              \r\n" + 
    					"					</form>       \r\n" + 
    					"                </li>\r\n" + 
    					"                \r\n" + 
    					"                <li ><form action=\"view\" method=\"post\"><button type=\"submit\" class=\"fa fa-search\" style=\"color:white\">View All</button></form></li>\r\n" + 
    					"                \r\n" + 
    					"                <li ><form action=\"search_product\" method=\"post\"><button type=\"submit\" class=\"fa fa-search\" style=\"color:white\">Search</button></form></li>\r\n" + 
    					"                \r\n" + 
    					"            </ul>\r\n" + 
    					"        </nav>\r\n" + 
    					"        <article>\r\n" + 
    					"           \r\n" + 
    					"            <div class=\"content\">\r\n" + 
    					"                <div class=\"container-contact100\">\r\n" + 
    					"		<div class=\"wrap-contact100\">\r\n" + 
    					"		<form action=\"product_output\" class=\"contact100-form\" method=\"post\">\r\n" + 
    					"				<h1><span class=\"contact100-form-title\">\r\n" + 
    					"					Delivery\r\n" + 
    					"				</span>\r\n" + 
    					"				</h1>\r\n" + 
    					"				<div class=\"wrap-input100 bg1 contact100-form-title\" data-validate=\"Please Type Your Name\">\r\n" + 
    					"				<h3 style=\"size:10px; color:black\" >\r\n" + 
    					"					Select Product\r\n" + 
    					"				</h3>\r\n" + 
    					"				<select class=\"form-control\" name=\"product_name\" onchange=\"this.form.submit()\">\r\n" + 
    					"				  <option selected=\"selected\" >Product...</option>\r\n" + 
    					"				  \r\n" ;
    			while(rs.next())
				{
				pre+=	"                            <option value="+rs.getString(1)+">"+rs.getString(1)+"</option>\r\n" ;
						}
				
    			pre+=
    					"				</select>\r\n" + 
    					"				</div>\r\n" + 
    					"				\r\n" + 
    					"					\r\n" + 
    					"		</form>\r\n" + 
    					"			</div>\r\n" + 
    					"	</div>\r\n" + 
    					"                \r\n" + 
    					"            </div>\r\n" + 
    					"        </article>\r\n" + 
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
