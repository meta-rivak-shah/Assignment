package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class RegisterVehicle
 */
@WebServlet("/RegisterVehicle")
public class RegisterVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterVehicle() {
        super();
        this.ServiceLayerObj = new ServiceLayer();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submit") !=null) {
			String veichleName = request.getParameter("name");
			String vType = request.getParameter("Type");
			String vehicleNum = request.getParameter("VehicleNum");
			String employeeid = request.getParameter("Employeeid");
			String identity = request.getParameter("identity");
			ArrayList<String> ErrorList = new ArrayList<String>();
			try {
				ErrorList = ServiceLayerObj.validateVeichleData(veichleName ,vehicleNum , vType,employeeid  , identity ,request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(ErrorList == null) {
				
				  request.setAttribute("Success", "Your Veichle is Register");
				  request.getRequestDispatcher("veichleRegister.jsp").forward(request, response);
			}
			else if(ErrorList.size() == 0) {
				 request.setAttribute("Duplicate", "Vehicle Allready Register");
				  request.getRequestDispatcher("veichleRegister.jsp").forward(request, response);
			}
			else {
				 request.setAttribute("Error", ErrorList);
				  request.getRequestDispatcher("veichleRegister.jsp").forward(request, response);

			} 
		} else {
			 request.setAttribute("formNotFill", "Please fill the form first");
			  request.getRequestDispatcher("veichleRegister.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
