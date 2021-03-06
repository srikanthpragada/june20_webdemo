package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class JobsHandler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		out.println("<h2>Jobs</h2>");

		try {

			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setCommand("select * from jobs");
			crs.execute();
			
			out.println("<table border='1'> <tr><th>Title </th><th> Min Salary </th></tr>");
			
			while ( crs.next())
			{
				out.println("<tr><td>" + crs.getString("job_title")
				    + "</td><td>" + crs.getString("min_salary") + "</td></tr>");
			}
			
			out.println("</table>");
			crs.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
