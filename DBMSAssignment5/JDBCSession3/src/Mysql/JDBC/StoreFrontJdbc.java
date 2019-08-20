package Mysql.JDBC;

import java.sql.*;
import java.util.ArrayList;

/**
 * the class StoreFrontJdbc is used for get the result of all the query we are
 * connection mysql database and run all the query using the all database table
 * 
 * @author Rivak
 *
 */
public class StoreFrontJdbc {
	ArrayList<AllOrderOfUser> AllOrderOfUser = new ArrayList<AllOrderOfUser>();
	ArrayList<ParentAndTotalChild> ParentAndTotalChild = new ArrayList<ParentAndTotalChild>();
	private SqlConnector sqlObj;

	/**
	 * this constructor is used to connect the database
	 */
	StoreFrontJdbc() {
		this.sqlObj = new SqlConnector("com.mysql.jdbc.Driver", "amazon");

	}

	/*
	 * the getter is used to get the obj of sql
	 */
	public SqlConnector getSqlObj() {
		return sqlObj;
	}

	/*
	 * this function is used for Assignment 1: Given the id of a user, fetch all
	 * orders (Id, Order Date, Order Total) of that user which are in shipped
	 * state. Orders should be sorted by order date column in chronological
	 * order.
	 */
	public ArrayList<AllOrderOfUser>  getUserCompleteDetails(int id) throws SQLException {
		int isGet = 0;

		String query = "SELECT  i.status , U.name As name,sum(i.TotalAmount) As TotalAmount, O.Order_Id , O.OrderDate FROM"
				+ " orders O   INNER JOIN  item_order I ON O.user_id ="
				+ id
				+ " AND i.status = 'S' AND I.Order_Id = O.Order_Id"
				+ " LEFT JOIN  User U ON U.id = "
				+ id
				+ " Group by O.Order_Id"
				+ " Order By O.OrderDate";

		ResultSet rs;
		rs = this.getSqlObj().executeQuery(query); // execute the perticular
													// query
		while (rs.next()) {
			isGet = 1;
			String status = rs.getString("status");
			String name = rs.getString("name");
			int totalAmount = rs.getInt("TotalAmount");
			Date dateCreated = rs.getDate("OrderDate");
			int orderId = rs.getInt("order_id");
			AllOrderOfUser.add(new AllOrderOfUser(status, name, totalAmount, dateCreated, orderId));
			
		}
		if (isGet != 1) {
			return null;
		}
		return AllOrderOfUser;
	}

	/*
	 * Assignment 2: Insert five or more images of a product using batch insert
	 * technique. return the int value which show data is get or not
	 */
	public int insertImageUsingBatch(String[] image, int[] productId)
			throws SQLException {
		String[] query = new String[image.length];
		for (int i = 0; i < productId.length; i++) {
			query[i] = "INSERT INTO image (Prod_Id, name) " + "VALUES("
					+ productId[i] + "," + image[i] + ");";
		}
		int result = sqlObj.insertDataThroughtBatch(query);
		sqlObj.connectMysql().close();
		return result;
	}

	/*
	 * Assignment 3: Delete all those products which were not ordered by any
	 * Shopper in last 1 year. Return the number of products deleted.
	 */
	public void deleteProductWhichNotOrder() throws SQLException {
		String query = "DELETE  FROM PRODUCT WHERE ID NOT IN ("
				+ "SELECT i.PRODUCT_Id FROM item_order i INNER join orders o ON o.Order_ID = i.ORDER_ID"
				+ " AND DATEDIFF(Now(), o.orderdate) < 30)";
		int result = sqlObj.executeUpdate(query);
		System.out.println("Total Row Deleted is -> " + result);
		sqlObj.connectMysql().close();
	}

	/*
	 * Assignment 4: Select and display the category title of all top parent
	 * categories sorted alphabetically and the count of their child categories.
	 */
	public ArrayList<ParentAndTotalChild> findTopCategoryAndChild() throws SQLException {
		String query = "SELECT count(pc.parentId) As Total_Child , c.type As Parent"
				+ " FROM CATEGORY c LEFT JOIN CATEGORY pc "
				+ "ON c.id = pc.parentid  "
				+ "GROUP BY pc.parentId"
				+ " ORDER BY c.type;";
		ResultSet rs;
		rs = this.getSqlObj().executeQuery(query);
		int isGet = 0;
		while (rs.next()) {
			isGet = 1;
			int Total_Child = rs.getInt("Total_Child");
			String Parent = rs.getString("Parent");
			ParentAndTotalChild.add(new ParentAndTotalChild(Total_Child, Parent));
		}
		if (isGet != 1) {
			return null;
		}
		return ParentAndTotalChild;
	}
	
	
	

}
