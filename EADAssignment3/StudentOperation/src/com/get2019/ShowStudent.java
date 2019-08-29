package com.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("id") != null) { // is user click on update so id is set other wise id is not set so it show data of student
			int id1 = Integer.parseInt(request.getParameter("id"));
			String query = "SELECT * FROM studentDetails WHERE id=" + id1;
			ResultSet rs;
			try {
				rs = SqlConnector.executeQuery(query);
				while (rs.next()) {
					int id = rs.getInt("id");
					out.println("<h1 align='center'>Update Student</h1>"
							+ " <form action ='./ShowStudent?id="+id+"' method ='Post'>"
							+ "<table align='center' cellspacing='50'>"
							+ "<tr>"
							+ "<th>First Name</th>"
							+ "<td><input id='name' type='text' name='firstName' placeholder='Enter your First Name' value="
							+ rs.getString("name").split(" ")[0]
							+ " required> </td>"
							+ "</tr>"
							+ "<tr>"
							+ "<th>Last Name</th>"
							+ "<td><input id='name' type='text' name='LastName' placeholder='Enter your Last Name' value="
							+ rs.getString("name").split(" ")[1]
							+ " required> </td>"
							+ "</tr>"
							+ "<tr>"
							+ "<th>Email</th>"
							+ "<td><input id='name' type='Email' name='email' placeholder='Enter your Email' value="
							+ rs.getString("email")
							+ " required> </td>"
							+ "</tr>"
							+ "<tr><th><button type='submit'>Update</button></th></tr>" + " </table>" + " </form>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			//if id is not set show ALL Data of student inside it
			String name = request.getParameter("search");
			String query = "SELECT * FROM studentDetails";
			ResultSet rs;
			try {
				rs = SqlConnector.executeQuery(query);
				out.println("<table align='center' cellspacing ='30'> "
						+ "<tr> " + "<th>Id</th>" + "<th>Name</th>"
						+ "<th>Email</th>" + "<th>Father Name</th>"
						+ "<th>Age</th>" + "<th>Class</th>" + "<th>Update</th>"
						+ "</tr>" + "</table>");
				while (rs.next()) {
					int id = rs.getInt("id");
					out.println("<table align='center' cellspacing ='30'> "
							+ "<tr> " + "<td>"
							+ id
							+ "</td>"
							+ "<td>"
							+ rs.getString("name")
							+ "</td>"
							+ "<td>"
							+ rs.getString("email")
							+ "</td>"
							+ "<td>"
							+ rs.getString("fatherName")
							+ "</td>"
							+ "<td>"
							+ rs.getInt("age")
							+ "</td>"
							+ "<td>"
							+ rs.getInt("class")
							+ "</td>"
							+ "<td><a href='./ShowStudent?id="
							+ id
							+ "'>UPDATE</a></td>" + "</tr>" + "</table>");
					
				}
				out.println("<h1><a href='./ShowStudent'>Show Student</a></h1>");
			    out.println("<h1><a href ='SearchStudent.html'>Search Student</a></h1>");
			    out.println("<h1><a href ='AddStudent.html'>Add Student</a></h1>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/**
	 * this is the post method when user click on the update button post method is call and update the user data
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			String name = firstName+" "+LastName;
			String query = "UPDATE  studentDetails set name = '"+name+"', email ='"+email+"' WHERE id ="+id;
			System.out.println(query);
			try {
				int queryResult = SqlConnector.executeUpdateQuery(query);
				if(queryResult == 1) {
					out.println("<h1>DATA IS UPDATE SUCCESFULLY</h1>");
					String site = new String("http://localhost:8080/StudentOperation/ShowStudent");
				    response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
				    response.setHeader("Location", site); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
