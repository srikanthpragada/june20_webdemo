<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<form action="">
		Employee Id : <input type="text" name="id" /> <input type="submit"
			value="Get Details" />
	</form>

	<%
		if (request.getParameter("id") == null)
			return;
	%>
	
	<jsp:useBean class="beans.Employee" scope="page" id="emp" />
	<jsp:setProperty property="id" name="emp"/>
	<h2>
	   <jsp:getProperty name="emp" property="name" />
	</h2> 
	
	
	



</body>
</html>