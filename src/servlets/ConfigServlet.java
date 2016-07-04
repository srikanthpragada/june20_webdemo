package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  PrintWriter pw = resp.getWriter();
	  pw.println("<h1>Config</h1>");
	  
	  String filename = getServletConfig().getInitParameter("file");
	  pw.println("<h2>" + filename + "</h2>");
	}
	
	

}
