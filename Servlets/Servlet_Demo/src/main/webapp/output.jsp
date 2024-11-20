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

<h1><% request.getAttribute("key"); %></h1>

<% Object obj=request.getAttribute("key"); 
	ResultSet result=(ResultSet)obj;
%>


<% while(result.next()){  %>

<%= result.getInt(1)+" "+ result.getString(2)+" "+result.getString(3)+" "+result.getInt(4)+" "+result.getString(5) %><br>

<% } %>

</body>
</html>