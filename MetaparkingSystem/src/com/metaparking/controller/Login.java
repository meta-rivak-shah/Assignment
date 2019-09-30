package com.metaparking.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        this.ServiceLayerObj = new ServiceLayer();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submit") == null) {
			 request.setAttribute("message", "Please Submit the form");
			  request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("Email");
		int check=0;
		try {
			ResultSet userData = ServiceLayerObj.authenticateUser(password, email);
			while(userData.next()) {
					check = 1;
					HttpSession session = request.getSession(true);
					session.setAttribute("user", userData.getInt("id"));
			} 
			if(check == 0) {
				request.setAttribute("AuthenicationFailed", "Please Enter Valid Details");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				response.sendRedirect("veichleRegister.jsp");
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
