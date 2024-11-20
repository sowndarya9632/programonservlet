package com.jsp.servlet.mobile_management_system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sending-id")
public class UpdateMobileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("mobileId"));
		
		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile-management-system","root","root");

			PreparedStatement pst= conn.prepareStatement("Select * from mobile where mobileId=?");

			pst.setInt(1,id);
		
			ResultSet res=pst.executeQuery();
			req.setAttribute("resultSet", res);
			req.getRequestDispatcher("UpdateMobile.jsp").forward(req, resp);
			

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
