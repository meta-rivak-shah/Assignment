package com.metaparking.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistration() {
		super();
		this.ServiceLayerObj = new ServiceLayer();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submit") == null) {
			 request.setAttribute("message", "Please Submit the form");
			  request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)s
	 */
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> ErrorList = new ArrayList<String>();
		String name = request.getParameter("name");
		String email = request.getParameter("Email");
		String organisation = request.getParameter("organisation");
		String password = request.getParameter("Password");
		String PasswordC = request.getParameter("Password-c");
		String gender = request.getParameter("Gender");
		System.out.println(gender);
		String contact = request.getParameter("Contact");
		try {
			ErrorList = ServiceLayerObj.validateUserData(name, email, organisation,
					password, PasswordC, gender, contact);
		} catch (Exception e) {
			e.printStackTrace();
		}
			if(ErrorList == null) {
				
				  request.setAttribute("Success", "Rivak");
				  request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else if(ErrorList.size() == 0) {
				  request.setAttribute("duplicat", "User is allredy register");
				  request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				 request.setAttribute("Error", ErrorList);
				  request.getRequestDispatcher("index.jsp").forward(request, response);

			}
	}
}
