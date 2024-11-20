package com.servlet.project.lifecycle;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/on-click")
public class Lifecycle extends GenericServlet  {

	@Override
	public void init() throws ServletException {
		System.out.println("init() method is Called");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			System.out.println("service() Method is Called");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() method is Called");
	}
	

}
