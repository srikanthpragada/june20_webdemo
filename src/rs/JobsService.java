package rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import oracle.jdbc.rowset.OracleCachedRowSet;

@Path("/jobs")
public class JobsService {

	@GET
	public String getJobs() {

		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs");
			crs.execute();
			ArrayList<Job> jobs = new ArrayList<>();
			while (crs.next()) {
				Job j = new Job();
				j.setId(crs.getString("job_id"));
				j.setTitle(crs.getString("job_title"));
				j.setMinSal(crs.getInt("min_salary"));
				j.setMaxSal(crs.getInt("max_salary"));
				jobs.add(j);
			}
			crs.close();

			Gson gson = new Gson();
			return gson.toJson(jobs);

		} catch (Exception ex) {
			throw new NotFoundException();
		}

	}

	@Path("/{id}")
	@GET
	public String getJob(@PathParam("id") String id) {
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select * from jobs where job_id = ?");
			crs.setString(1, id);
			crs.execute();
			if (crs.next()) {
				Job j = new Job();
				j.setId(crs.getString("job_id"));
				j.setTitle(crs.getString("job_title"));
				j.setMinSal(crs.getInt("min_salary"));
				j.setMaxSal(crs.getInt("max_salary"));
				Gson gson = new Gson();
				return gson.toJson(j);
			} else
				throw new NotFoundException();
		} catch (Exception ex) {
			throw new NotFoundException();
		}
	}

	@Path("/{id}/Employees")
	@GET
	public String getEmployees(@PathParam("id") String id) {
		try {
			OracleCachedRowSet crs = new OracleCachedRowSet();
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			crs.setUsername("hr");
			crs.setPassword("hr");
			crs.setCommand("select first_name, salary from employees where job_id = ?");
			crs.setString(1, id);
			crs.execute();
			ArrayList<Employee> emps = new ArrayList<>();
			while (crs.next()) {
				Employee e = new Employee();
				e.setName( crs.getString(1));
				e.setSalary( crs.getInt(2));
				emps.add(e);
			}
			crs.close();

			Gson gson = new Gson();
			return gson.toJson(emps);
		} catch (Exception ex) {
			throw new NotFoundException();
		}
	}

	@Path("/{id}")
	@DELETE
	public void deleteJob(@PathParam("id") String id) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			PreparedStatement ps = con.prepareStatement("delete from jobs where job_id = ?");
			ps.setString(1, id);
			int count = ps.executeUpdate();
			if (count == 0)
				throw new NotFoundException();
			else
				System.out.println(id + " job deleted!");
			
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
			throw new NotFoundException();
		}

	}

	@POST
	public String addJob(@QueryParam("id") String id, @QueryParam("title") String title) {
		return "Adding job " + id + ":" + title;
	}

}
