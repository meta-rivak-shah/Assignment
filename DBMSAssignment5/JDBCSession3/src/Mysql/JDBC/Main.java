package Mysql.JDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * the main class is used to get all the resultant data of the query in the form of list
 */
public class Main {

	public static void main(String[] args) throws SQLException {
		StoreFrontJdbc StoreFrontJdbcObj = new StoreFrontJdbc();
		System.out.println("Enter the user Id");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		ArrayList<AllOrderOfUser> AllOrderOfUser = StoreFrontJdbcObj//POJOS OF ALL ORDER OF USER
				.getUserCompleteDetails(id);
		for (int i = 0; i < AllOrderOfUser.size(); i++) {
			System.out.println(AllOrderOfUser.get(i).getName() + "----"
					+ AllOrderOfUser.get(i).getOrderId() + "----"
					+ AllOrderOfUser.get(i).getTotalAmount() + "----"
					+ AllOrderOfUser.get(i).getStatus() + "----"
					+ AllOrderOfUser.get(i).getDateCreated());
			System.out.println();
		}
		String image[] = new String[] { "'12.jpg'", "'13.jpg'", "'13.jpg'",
				"'14.jpg'", "'15.jpg'", "'16.jpg'", "'17.jpg'", "'18.jpg'",
				"'19.jpg'", "'110.jpg'" };
		int ProductId[] = new int[] { 1, 1, 1, 2, 2, 2, 1, 1, 2, 3 };

		int result = StoreFrontJdbcObj.insertImageUsingBatch(image, ProductId);
		if (result == 1) {
			System.out.println("Data is Inserted");
		} else {
			System.out.println("Not Inserted");
		}

		StoreFrontJdbcObj.deleteProductWhichNotOrder();
		ArrayList<ParentAndTotalChild> ParentAndTotalChild = StoreFrontJdbcObj //POJOS OF ALL PARENT OF USER
				.findTopCategoryAndChild();
		for (int i = 0; i < ParentAndTotalChild.size(); i++) {
			System.out.println(ParentAndTotalChild.get(i).getParent() + "----"
					+ ParentAndTotalChild.get(i).getTotal_Child());
			System.out.println();
		}
	}
}
