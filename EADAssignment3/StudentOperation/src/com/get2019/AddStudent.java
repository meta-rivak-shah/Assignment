package com.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      function is used to get the data of the form in this method is used is post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName  = request.getParameter("firstName");
		String lastName  = request.getParameter("LastName");
		String name = firstName.concat(" "+lastName);
		System.out.println(name);
		String email  = request.getParameter("email");
		String fatherName  = request.getParameter("fatherName");
		int studentClass = Integer.parseInt(request.getParameter("class"));
		int age = Integer.parseInt(request.getParameter("age"));
		String query = "INSERT INTO studentDetails(name ,email ,fatherName,class,age)VALUES('"+name+"','"+email+"','"+fatherName+"','"+studentClass+"','"+age+"')";
		try {
			int queryResult = SqlConnector.executeUpdateQuery(query);
			if(queryResult == 1){ //if the data is insert succefully then it will show the success message
				System.out.println(query);
			    response.setContentType("text/html"); //indicate that data is insert as text html type
			    PrintWriter out = response.getWriter();
			    out.println("<h1>Add  Student succefully</h1>");
			    out.println("<h1>"+name+"</h1>");
			    out.println("<h1><a href='./ShowStudent'>Show Student</a></h1>");
			    out.println("<h1><a href ='SearchStudent.html'>Search Student</a></h1>");
			    out.println("<h1><a href ='AddStudent.html'>Add Student</a></h1>");
			}else{//if query fails then transfer to other page
				 String site = new String("http://localhost:8080/StudentOperation/AddStudent.html");
			      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
			      response.setHeader("Location", site);    
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
