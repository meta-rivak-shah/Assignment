package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.model.User;
import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Profile() {
		super();
		this.ServiceLayerObj = new ServiceLayer();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<User> userData = new ArrayList<User>();
		HttpSession session = request.getSession(false);
		String userID = String.valueOf(session.getAttribute("user"));
		try {
			userData = ServiceLayerObj.getUserData(userID);
			if (userData != null) {
				request.setAttribute("userData", userData);
				request.getRequestDispatcher("profile.jsp").forward(request,
						response);
				
			} else if (userData.size() == 0) {
				request.setAttribute("Error", "try after some time");
				request.getRequestDispatcher("profile.jsp").forward(request,
						response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
