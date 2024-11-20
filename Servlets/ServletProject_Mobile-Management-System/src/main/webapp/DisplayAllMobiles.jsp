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
	ResultSet result=(ResultSet)request.getAttribute("key");
    %>

	<table border="4px" cellpadding="10px" cellspacing="0" align="center">

		<tr>
			<td colspan="6" align="center"><b>All Mobile Details</b></td>
		</tr>

		<tr>
			<th>MobileId</th>
			<th>MobileModel</th>
			<th>MobileBrand</th>
			<th>MobilePrice</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>

		<% while(result.next()){  %>
		
		<tr align="center">
			<td><%=result.getInt(1) %></td>
			<td><%=result.getString(2) %></td>
			<td><%=result.getString(3) %></td>
			<td><%=result.getInt(4) %></td>
			<td><a href="sending-id?mobileId=<%=result.getInt(1)%>">Update</a></td>
			<td><a href="delete?mobileId=<%=result.getInt(1)%>">Delete</a></td>
		</tr>
		
		<% } %>
		
	</table>

<h2><a href="index.jsp">Go Back To DashBoard</a></h2>

</body>
</html>