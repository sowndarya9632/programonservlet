package com.jsp.servlet_project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/everything")

public class DemoServlet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

//		int name=Integer.parseInt(req.getParameter("n"));
		String name=req.getParameter("n");
//		
//		req.setAttribute("key", name);
//		req.getRequestDispatcher("output.jsp").include(req, res);
//		PrintWriter pw = res.getWriter();
//		pw.print("<h1> Hello!...</h1>");
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb","root","root");
			
			PreparedStatement pst= conn.prepareStatement("select * from employee where designation=?");
			
			pst.setString(1, name);
			
			
			ResultSet result =pst.executeQuery();
			
			req.setAttribute("key", result);
			req.getRequestDispatcher("output.jsp").include(req, res);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
