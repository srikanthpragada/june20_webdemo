package rs;


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
	public  String  getJobs() {
		return "All Jobs"; 
	}
	
	
	@Path("/{id}")
	@GET
	public  String  getJob(@PathParam("id") String id) {
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
	public  String  getEmployees(@PathParam("id") String id) {
		return "Employees of " + id; 
	}

	
	@Path("/{id}")
	@DELETE 
	public  String  deleteJob(@PathParam("id") String id) {
		return "Deleting job  " + id; 
	}
	

	@POST 
	public  String addJob(@QueryParam("id") String id,
			              @QueryParam("title") String title) {
		return "Adding job " +  id  + ":" + title; 
	}

}














