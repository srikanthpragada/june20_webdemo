package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class Jobs3Handler extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();
		PageContext  ctx = (PageContext) getJspContext();
		JspFragment body = this.getJspBody();

		try {

			CachedRowSet crs = new OracleCachedRowSet();
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setCommand("select * from jobs");
			crs.execute();
			
			while ( crs.next())
			{
                 ctx.setAttribute("id", crs.getString("job_id"));
                 ctx.setAttribute("title", crs.getString("job_title"));
                 ctx.setAttribute("min", crs.getInt("min_salary"));
                 ctx.setAttribute("max", crs.getInt("max_salary"));
                 
                 if (body != null)
                	 body.invoke(out); // process body and send output to writer 
                
			}
			

			crs.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
