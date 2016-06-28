package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Updates Employee's Salary", urlPatterns = { "/updateSalary" })
public class UpdateSalaryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String empid = request.getParameter("empid");
		 String salary = request.getParameter("salary");
		 
		 response.setContentType("text/html");
		 
		 PrintWriter pw = response.getWriter();
		 try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
            PreparedStatement ps = con.prepareStatement("update employees set salary = ? where employee_id = ?");
            ps.setInt(1, Integer.parseInt(salary));
            ps.setInt(2, Integer.parseInt(empid));
            int count = ps.executeUpdate();
            if ( count == 1)
            	 pw.println("<h2>Updated Salary Successfully!</h2>");
            else
            	 pw.println("<h2>Sorry! Employee id not found!</h2>");
            con.close();
		 }
		 catch(Exception ex) {
			 System.out.println(ex.getMessage());
			 pw.println("<h2>Sorry! Something went wrong. Try again!</h2>");
		 }
		
	}

}
