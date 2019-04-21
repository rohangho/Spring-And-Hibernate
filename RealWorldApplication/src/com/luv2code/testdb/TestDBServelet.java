package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testDBServelet
 */
@WebServlet("/testDBServelet")
public class TestDBServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TestDBServelet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user="springstudent";
		String pass="springstudent";
		
		String jdbcURL="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver="com.mysql.jdbc.Driver";
		try {
			
			PrintWriter out= response.getWriter();
			
			out.println("Connecting to database" + jdbcURL);
			
			Class.forName(driver);
			
			Connection myCon=DriverManager.getConnection(jdbcURL,user,pass);
			
			out.println("Connection Successful");
			
			myCon.close();
			
			
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
			throw new ServletException();
		}
		
	}

}
