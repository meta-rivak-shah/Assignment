package com.get2019;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      this function is used to show the dATA of perticular student when user give into the input filled
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search");
		String query = "SELECT * FROM studentDetails WHERE name='" + name + "'";
		ResultSet rs;
		try {
			rs = SqlConnector.executeQuery(query);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<table align='center' cellspacing ='30'> " + "<tr> "
					+ "<th>Id</th>" + "<th>Name</th>" + "<th>Email</th>"
					+ "<th>Father Name</th>" + "<th>Age</th>"
					+ "<th>Class</th>" + "</tr>" + "</table>");
			while (rs.next()) {
				out.println("<table align='center' cellspacing ='30'> "
						+ "<tr> " + "<td>" + rs.getInt("id") + "</td>" + "<td>"
						+ rs.getString("name") + "</td>" + "<td>"
						+ rs.getString("email") + "</td>" + "<td>"
						+ rs.getString("fatherName") + "</td>" + "<td>"
						+ rs.getInt("age") + "</td>" + "<td>"
						+ rs.getInt("class") + "</td>" + "</tr>" + "</table>");
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
