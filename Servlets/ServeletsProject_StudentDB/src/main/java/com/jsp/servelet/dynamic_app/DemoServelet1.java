package com.jsp.servelet.dynamic_app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoServelet1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("n");
		System.out.println(name);
		
		PrintWriter pw=res.getWriter();
		pw.print("<h1> Welcome To IntrenShip "+name+"!!</h1>");
	}

}

