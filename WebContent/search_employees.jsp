<%@page
	import="javax.sql.rowset.CachedRowSet,oracle.jdbc.rowset.OracleCachedRowSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Search</title>
</head>
<body>

	<h2>Employee Search</h2>

	<form>
		Employee Name : <input type="text" name="ename" value="${param.ename}"
		    required="required" />
		<input type="checkbox" name="cis"/>Case Insensitive
		<input type="submit" value="Search" />
		<p/>
	</form>

	<%
		String name = request.getParameter("ename");
		if (name == null)
			return;

		// search for employees by name 
		CachedRowSet crs = new OracleCachedRowSet();
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setCommand("select * from employees where first_name like ?");
		crs.setString(1, "%" + name + "%");
		crs.execute();
		
		if (! crs.first())
		{
			out.println("<h3>Sorry! No employees found!</h3>");
			crs.close();
			return;
		}
			
			
	%>

	<table border="1" style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
		</tr>
	


     <% 
        crs.beforeFirst();
        while ( crs.next()) {
     %>    	   
    	<tr>
    	    <td> <%=crs.getString("first_name")%> </td>
    	    <td> <%=crs.getString("job_id")%> </td>
    	    <td> <%=crs.getInt("salary")%> </td>
   	    </tr>
     <% 	 
     
       }

       crs.close();
	%>
</table>

</body>
</html>
