<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Today</title>
</head>
<body>

 <h1>
 
    <%
        out.println(  new java.util.Date() );
    %>
 </h1>

</body>
</html>