package com.jsp.servlet.mobile_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add-mobile")
public class AddMobileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int mobileId=Integer.parseInt(req.getParameter("id"));
		String model=req.getParameter("model");
		String brand=req.getParameter("brand");
		int price=Integer.parseInt(req.getParameter("price"));

		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile-management-system","root","root");

			PreparedStatement pst= conn.prepareStatement("INSERT INTO mobile VALUES(?,?,?,?)");

			pst.setInt(1, mobileId);
			pst.setString(2,model);
			pst.setString(3,brand);
			pst.setInt(4,price);

			pst.execute();

			resp.sendRedirect("index.jsp");



		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}




}
