package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/emailuploader")
@MultipartConfig
public class EmailUploaderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		Part file = request.getPart("emailfile");
		InputStream  is  = file.getInputStream();
		BufferedReader br = new BufferedReader( new InputStreamReader(is));
		
		String line = br.readLine();
		StringBuffer buf = new StringBuffer();
		while( line != null) {
			buf.append(line);
			line = br.readLine();
		}
		is.close();
		
		String emails [] = buf.toString().split(";");
		
		PrintWriter pw = response.getWriter();
		
		for(String email : emails) 
		{
			if ( email.contains("@") &&  email.contains("."))
		           pw.println(email + "<p/>");
		}
	}

}
