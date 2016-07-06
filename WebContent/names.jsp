<%@ page language="java" 
    contentType="text/html; charset=ISO-8859-1"
    import ="java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Names</title>
</head>
<body>

  <%
     String name = request.getParameter("name");
  
     ArrayList<String> names = (ArrayList<String>) session.getAttribute("names");
     
     if (names == null)
     {
    	 names = new ArrayList<String>();
    	 session.setAttribute("names", names);
     }
     
     names.add(name);
  %>
  
  <h2>Names</h2>
  <%
      // print names
      for(String n : names)
    	  out.println(n + "<br/>");

  %>

</body>
</html>