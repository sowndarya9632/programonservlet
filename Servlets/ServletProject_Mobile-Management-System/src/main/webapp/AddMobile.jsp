<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter The Mobile Details</h1>

	<form action="add-mobile" method="post">
		<input type="number" placeholder="Enter The MobileId" name="id"><br>
		<br> <input type="text" placeholder="Enter The MobileModel" name="model"><br>
		<br> <input type="text" placeholder="Enter The MobileBrand" name="brand"><br>
		<br> <input type="number" placeholder="Enter The MobilePrice" name="price"><br>
		<br> <input type="submit" value="ADD">
	</form>

</body>
</html>