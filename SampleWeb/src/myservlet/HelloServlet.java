package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("I am in Get Method!");
		//set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		//create HTML form
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
		.append("<html>\r\n")
		  .append("		<head>\r\n")
		  .append("			<title>Form input</title>\r\n")
		  .append("		</head>\r\n")
		  .append("		<body>\r\n")
		  .append("			<form action=\"HelloServlet\" method=\"POST\">\r\n")
		  .append("				Enter your name: \r\n")
		  .append("				<input type=\"text\" name=\"user\" />\r\n")
		  .append("				<input type=\"submit\" value=\"Submit\" />\r\n")
		  .append("			</form>\r\n")
		  .append("		</body>\r\n")
		  .append("</html>\r\n");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("In Post Method!");
		
		String user = request.getParameter("user");
		
		// create HTML response
		PrintWriter writer = response.getWriter();

		if (user != null && !user.trim().isEmpty()) {
			writer.append("	Welcome " + user + ".\r\n");
			writer.append("	You successfully completed this.\r\n");
		} else {
			writer.append("	You did not entered a name!\r\n");
		}

	}
}
