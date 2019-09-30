package com.metaparking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.service.ServiceLayer;

/**
 * Servlet implementation class PrintGatePass
 */
@WebServlet("/PrintGatePass")
public class PrintGatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceLayer ServiceLayerObj; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintGatePass() {
        super();
        this.ServiceLayerObj = new ServiceLayer();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price = request.getParameter("price");
			PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession(false);
		 String vid =   String.valueOf(session.getAttribute("vId"));
		 String userId =   String.valueOf(session.getAttribute("user"));
		  try {
			int result =ServiceLayerObj.createAGatePAss(Integer.parseInt(price) , Integer.parseInt(vid) , Integer.parseInt(userId));
			if(result == 1) {
				out.print("<h1>Total Amount of gate pass is ->"+price+"USD</h1>");
				out.print("<a href='logout'>Logout</a>");
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
