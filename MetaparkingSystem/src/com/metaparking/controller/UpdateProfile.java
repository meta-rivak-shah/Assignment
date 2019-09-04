package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfile() {
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
			request.getRequestDispatcher("Profile").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userID = String.valueOf(session.getAttribute("user"));
		String name = request.getParameter("name");
		String contact = request.getParameter("number");
		String password = request.getParameter("pwd");
		System.out.println("ssss");
		try {
			int result  = ServiceLayerObj.UpdateUserData(name,
					password, contact , userID);
			if(result == 1) {
				response.sendRedirect("profile.jsp");
			} else {
				response.sendRedirect("profile.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
