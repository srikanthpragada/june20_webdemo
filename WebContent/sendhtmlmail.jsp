<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Send Mail</title>
</head>
<body>
	<h2>Send Mail</h2>
	<form action="sendhtmlmail.jsp" method="post">
		To Address <br /> <input type="text" name="to" />
		<p />
		From Address <br /> <input type="text" name="from" />
		<p />
		Subject <br /> <input type="text" name="subject" />
		<p />
		Body <br />
		<textarea name="body" rows="5" cols="80"></textarea>
		<p />
		<input type="submit" value="Send Mail" />
	</form>

	<%
            if ( request.getParameter("to") == null)
                    return;

         %>

	<jsp:useBean class="beans.MailBean" id="mailBean" scope="page" />
	<jsp:setProperty name="mailBean" property="*" />
	<%
           try {
             mailBean.send();
             out.println("<h3>Mail sent successfully!</h3>");
           }
           catch(Exception ex) {
              out.println("<h3>Error : "  + ex.getMessage() + "</h3>");
           }  
    %>


</body>
</html>
