package com.metaparking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metaparking.model.VehicleDetails;
import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class GetVehicleNumber
 */
@WebServlet("/GetVehicleNumber")
public class GetVehicleNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVehicleNumber() {
        super();
        this.ServiceLayerObj = new ServiceLayer();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		ArrayList<VehicleDetails> vehicleDetails = new ArrayList<VehicleDetails>();
		try {
			vehicleDetails = ServiceLayerObj.getVeichleDetails(empId);
			if(vehicleDetails.size() >0) {
				 request.setAttribute("vehicleDetails", vehicleDetails);
				 request.getRequestDispatcher("gatepass.jsp").forward(request, response);
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
