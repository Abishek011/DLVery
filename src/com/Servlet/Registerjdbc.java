package com.Servlet;
import java.sql.*;

import org.apache.log4j.Logger;

import com.Servlet.Register;
public class Registerjdbc{  
	static Logger log = Logger.getLogger(Registerjdbc.class);
public void Registerjd(Register Register,String team) throws Exception{  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dlvery","raja","raja");
		String CREATE_TABLE=" CREATE TABLE IF NOT EXISTS "+team+"( username varchar(20) not null, dob varchar(20),email varchar(50),password varchar(20))";
		con.createStatement().executeUpdate(CREATE_TABLE);
		String INSERT_USERS_SQL = "INSERT INTO "+team+
		        "  (username,dob,email,password) VALUES " +
		        " (?, ?, ?, ?)";  
		
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(2, Register.getDob());
            preparedStatement.setString(1, Register.getUsername());
            preparedStatement.setString(4, Register.getPassword());
            preparedStatement.setString(3, Register.getEmail());
            preparedStatement.executeUpdate(); 
		log.info("The registration is started");
		con.close();  
		  
	}
	catch(Exception e){ 
		e.printStackTrace();
		System.out.println(e);}  
	  
	}  
}  