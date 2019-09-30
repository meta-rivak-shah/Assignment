package com.inventory.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




import com.inventory.model.Inventory;
import com.inventory.service.Service;

@Path("/inventory")
public class InventoryManagment {
	
	/**
	 * Method to get the whole Inventory
	 * @return {String}
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory> getWholeInventory() {
		Service serviceObj = new Service();
		List<Inventory> inventoryList = new ArrayList<>();
		try {
			inventoryList = serviceObj.getDataOfInvenotry();
			if(inventoryList.size() > 0) {
				return inventoryList ;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return "Exception occours" + e;
		}
	}
		
	/**
	 * Method to get an item from the Inventory
	 * @return {String}
	 */
    @GET
    @Path("/item")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inventory> getItemImformation( @QueryParam("name") String parameter1) {
 
	 Service serviceObj = new Service();
		List<Inventory> itemImformation = new ArrayList<>();
		try {
			itemImformation = serviceObj.getItemImformation(parameter1);
			if (itemImformation.size() > 0) {
				return itemImformation;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
 
    }
    
    /**
	 * Method to DELETE an item from the Inventory
	 * @return {String}
	 */
    @DELETE
    @Path("/deleteItem")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteItemImformation( @QueryParam("name") String parameter1) {
 
	 Service serviceObj = new Service();
		int result;
		try {
			result = serviceObj.deleteItemImformation(parameter1);
			if (result > 0) {
				return "Your Item Is Deleted Succefully";
			} else {
				return "No Data Found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception occours" + e;
		}
 
    }
    
    /**
	 * Method to UPDATE an item from the Inventory
	 * @return {String}
	 */
    @PUT
    @Path("/UpdateItem")
    @Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateItemImformation(Inventory inventory)
	{
    	Service serviceObj = new Service();
		try {
			if(serviceObj.updateItemImformation(inventory.getName(), inventory.getQuantity()) > 0)
			{
				return "Data Updated Succefully";
			}
			else
			{
				return "There was an error while inserting the data";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e+"Exception is there";
		}
	}
    
    /**
  	 * Method to Insert an item from the Inventory
  	 * @return {String}
  	 */
    @POST
    @Path("/InsertItem")
	@Produces("text/plain")
    @Consumes(MediaType.APPLICATION_JSON)
	public String insertItemToInventory(Inventory inventory)
	{
    	Service serviceObj = new Service();
		try {
			if(serviceObj.insertItemImformation(inventory.getName(), inventory.getQuantity()) > 0)
			{
				return "Data Inserted";
			}
			else
			{
				return "There was an error while inserting the data";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e+"Exception is there";
		}
	}
}