package com.Servlet;

import java.io.*;


//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
/**
 * Servlet implementation class TestLoginServlet
 */
@WebServlet("/testlog")
public class TestLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    			HttpSession session=request.getSession();
				session.removeAttribute("Username");
				response.sendRedirect("log.jsp");
	}

}
