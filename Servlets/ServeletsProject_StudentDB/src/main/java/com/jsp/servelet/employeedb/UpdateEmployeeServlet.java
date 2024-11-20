package com.jsp.servelet.employeedb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateEmployeeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		int employeeId =Integer.parseInt(req.getParameter("employeeId"));
		String employeeEmail=req.getParameter("employeeEmail");
		int employeeSalary=Integer.parseInt(req.getParameter("employeeSalary"));

		// JDBC Logic

		Connection conn=null;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb","root","root");

			PreparedStatement pst =conn.prepareStatement("UPDATE  employee set employeeSalary=?,employeeEmail=? where employeeId=?");
			pst.setInt(3, employeeId);
			pst.setInt(1,employeeSalary);
			pst.setString(2,employeeEmail);

			int result =pst.executeUpdate();
			
			PrintWriter pw =null;
			if(result>0) {
				pw =res.getWriter();
				pw.print("<h1>"+result+" Row is Updated </h1>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}



