package rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resthello")
public class RestHello {
	
	 @GET
	 public String greet() {
		 
		 return "Hello from Restful Service";
	 }

}
