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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int employeeId =Integer.parseInt(req.getParameter("employeeId"));
		String employeeName=req.getParameter("employeeName");
		String employeeEmail=req.getParameter("employeeEmail");
		int employeeSalary=Integer.parseInt(req.getParameter("employeeSalary"));
		String designation = req.getParameter("Designation");

		// JDBC Logic

		Connection conn=null;
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_employeedb","root","root");

			PreparedStatement pst =conn.prepareStatement("INSERT INTO employee values(?,?,?,?,?)");
			pst.setInt(1, employeeId);
			pst.setString(2,employeeName);
			pst.setString(3,employeeEmail);
			pst.setInt(4, employeeSalary);
			pst.setString(5, designation);

			int result =pst.executeUpdate();
			
			PrintWriter pw =null;
			if(result>0) {
				pw =res.getWriter();
				pw.print("<h1>"+result+" Row is Inserted </h1>");
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
