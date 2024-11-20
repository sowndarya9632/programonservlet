<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	ResultSet result=(ResultSet)request.getAttribute("resultSet");
result.next();
%>

	
	<h1>Enter the Mobile Details to Update</h1>
	<form action="update" method="post">
	
	<input type="number" value="<%=result.getInt(1) %>" name="mobileId" readonly="readonly"><br><br>
	<input type="text" value="<%=result.getString(2) %>" name="model"><br><br>
	<input type="text" value="<%=result.getString(3) %>" name="brand"><br><br>
	<input type="number" value="<%=result.getInt(4) %>" name="cost"><br><br>
	<input type="submit" value="UPDATE MOBILE">
	
	</form>

	
</body>
</html>