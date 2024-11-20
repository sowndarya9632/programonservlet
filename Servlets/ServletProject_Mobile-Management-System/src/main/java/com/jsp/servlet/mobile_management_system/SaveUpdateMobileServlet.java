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

@WebServlet("/update")
public class SaveUpdateMobileServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String model=req.getParameter("model");
		String brand=req.getParameter("brand");
		int price=Integer.parseInt(req.getParameter("cost"));
		int id=Integer.parseInt(req.getParameter("mobileId"));
		
		Connection conn=null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_mobile-management-system","root","root");

			PreparedStatement pst= conn.prepareStatement("UPDATE mobile SET mobileModel=?,mobileBrand=?,mobilePrice=? where mobileId=? ");
			
			pst.setInt(4,id);
			pst.setString(1,model);
			pst.setString(2,brand);
			pst.setInt(3,price);

			pst.execute();

			resp.sendRedirect("DisplayMobile");



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
