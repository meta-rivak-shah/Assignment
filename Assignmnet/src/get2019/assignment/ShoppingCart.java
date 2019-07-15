package get2019.assignment;

import java.util.*;

public class ShoppingCart extends Ecommerce {
	HashMap<String, Integer> productPrice = new HashMap<String, Integer>();
	HashMap<String, String> productDesctiprion = new HashMap<String, String>();
	HashMap<Integer, String> cartContainProductName = new HashMap<Integer, String>();
	HashMap<Integer, Integer> cartContainProductQunity = new HashMap<Integer, Integer>();
	String userInputProductName;
	String itemAvalibility = "NotAvalable";
	int primaryKey = 1;
	Scanner userInput = new Scanner(System.in);

	/*
	 * In this function allActivity perform basic activity like show all
	 * function name and add quantity product name and add to cart
	 * 
	 * @param functionName it contain all the name of function which we are
	 * perform
	 * 
	 * @param userInputChoice it take the choice of operation user want to
	 * perform
	 * 
	 * @param addCartResult it take return result of add cart function
	 * 
	 * @param continueInsertInput this variable indicate user want to insert
	 * more product or not
	 */
	public void allActivity() {
		String productName[] = new String[] { "Apple", "Mi", "Samsung", "Nokia" };
		String functionName[] = new String[] { "addProductToCart",
				"ShowProduct" };
		String userInputChoice;
		try {
			System.out.println("Enter  the Quntity");
			String userInputProductQuntiy = userInput.nextLine();
			// code that may raise InputMismatchException
			for (int function = 0; function < functionName.length; function++) {
				System.out.println(function + 1 + "-> "
						+ functionName[function]);
			}
			System.out.println("Select option to perfom activity");
			userInputChoice = userInput.nextLine();
			int userConvertChoice = Integer.parseInt(userInputChoice);
			switch (userConvertChoice) {
			case 1: {
				int addCartResult = addProductToCart(userInputProductName,
						userInputProductQuntiy);
				if (addCartResult == 1) {
					System.out.println("Your product add to cart");
					System.out
							.println("For insert more product write yes or GenrateBill to press any");
					String continueInsertInput = userInput.nextLine();
					if ("yes".equalsIgnoreCase(continueInsertInput)) {

						showProduct();
					} else {

						genrateBillOfCart(cartContainProductName,
								cartContainProductQunity);
					}

				}
				break;
			}
			case 2:
				showProduct();
				break;

			default: {
				System.out.println("Please Input valid Id");
				showProduct();
			}
			}
		} catch (InputMismatchException e) {
			System.out
					.println("Insert only integer value like->1,2,3 please again start");
		}

	}

	@Override
	/*
	 * In this function showProduct perform basic activity like show all Product
	 * name and add Price description of product and add to cart
	 * 
	 * @param productPrice it contain all the Price of Product
	 * 
	 * @paramproductPrice it contain all the Description of Product
	 */
	public void showProduct() {
		String productName[] = new String[] { "Apple", "Mi", "Samsung", "Nokia" };
		System.out.println("Welcome To Ecommerce");
		// TODO Auto-generated method stub
		productPrice.put("APPLE", 100);
		productPrice.put("MI", 200);
		productPrice.put("SAMSUNG", 300);
		productPrice.put("NOKIA", 400);

		productDesctiprion.put("APPLE", "Apple iphone-6 which hase 6mp camera");
		productDesctiprion.put("MI", "Mi iphone-6 which hase 6mp camera");
		productDesctiprion.put("SAMSUNG",
				"Samsung iphone-6 which hase 6mp camera");
		productDesctiprion.put("NOKIA", "Nokia iphone-6 which hase 6mp camera");

		for (int product = 0; product < productName.length; product++) {

			System.out.println(product + 1 + "-> " + productName[product]);
		}

		System.out.println("Insert name Of Product To  Get Details->");
		userInputProductName = userInput.nextLine();
		System.out.println("Your Input Product Is -> " + userInputProductName);
		if (productPrice.get(userInputProductName.toUpperCase()) != null) {
			itemAvalibility = "Avalable";
		} else {
			itemAvalibility = "NotAvalable";

		}
		System.out.println(itemAvalibility);
		if (itemAvalibility == "Avalable") {
			System.out.println("Price : "
					+ productPrice.get(userInputProductName.toUpperCase()));
			System.out
					.println("Description : "
							+ productDesctiprion.get(userInputProductName
									.toUpperCase()));
			allActivity();
		} else {

			System.out.println("Sorry Product is Not Avalable");
			if (cartContainProductName.size() > 0) {
				showProduct();
			}
		}

	}

	@Override
	public int addProductToCart(String productName, String quntity) {
		// TODO Auto-generated method stub
		int converQuntity;
		converQuntity = Integer.parseInt(quntity);
		if (cartContainProductName.size() > 0) {

			for (Map.Entry m : cartContainProductName.entrySet()) {
				String getCartValue = (String) m.getValue();
				if (getCartValue.equals(productName)) {

					int getCartKey = (int) m.getKey();
					int oldQuntity = cartContainProductQunity.get(getCartKey);
					int newQuntity = oldQuntity + converQuntity;
					cartContainProductQunity.put(getCartKey, newQuntity);
				} else {
					cartContainProductName.put(primaryKey, productName);
					cartContainProductQunity.put(primaryKey, converQuntity);
					primaryKey = primaryKey + 1;
				}

			}
		} else {
			cartContainProductName.put(primaryKey, productName);
			cartContainProductQunity.put(primaryKey, converQuntity);
			primaryKey = primaryKey + 1;
		}

		return 1;

	}

	@Override
	/*
	 * In this function updateProductToCart perform basic activity like Update
	 * all Product quantity and total amout of product and add to cart
	 * 
	 * @param productId it contain all the productId of Product which want to
	 * update Quantity quantity it contain all the quantity of Product which
	 * want to update
	 */
	public int updateProductToCart(int productId, int quntity) {
		if (quntity == 0) {
			cartContainProductQunity.remove(productId);
			cartContainProductName.remove(productId);

		} else {
			cartContainProductQunity.put(productId, quntity);
		}

		return 1;
	}

	@Override
	/*
	 * In this function genrateBillOfCart perform basic activity like generate
	 * Bill Of Cart all with Product quantity and total amout of product and add
	 * product price total cart amount and productId
	 * 
	 * @param cartContainProductName2 it contain all the productName of Product
	 * Quantity cartContainProductPrice it contain all the Price of Product
	 */
	public void genrateBillOfCart(
			HashMap<Integer, String> cartContainProductName,
			HashMap<Integer, Integer> cartContainProductPrice) {
		// TODO Auto-generated method stub
		int TotalAmount = 0;
		// System.out.print(cartContainProductName + " " +
		// cartContainProductQunity);
		System.out.println("Your Total Amount  Is");
		System.out
				.println("Product Id | Product Name | Product Quntity | Product Price | Total Amount");
		if (cartContainProductQunity.size() > 0) {
			for (Map.Entry m : cartContainProductName.entrySet()) {
				String productName = (String) m.getValue();
				// System.out.print(productName);
				int prouctId = (int) m.getKey();
				int productQunity = cartContainProductQunity.get(prouctId);
				int getProductPrice = productPrice.get(productName
						.toUpperCase());
				TotalAmount = TotalAmount + getProductPrice * productQunity;
				System.out
						.println("--------------------------------------------------------------------------");
				System.out.println(prouctId + "          |   " + productName
						+ "      |   " + productQunity + "              |   "
						+ getProductPrice + "         |   " + getProductPrice
						* productQunity);
				System.out
						.println("--------------------------------------------------------------------------");

			}
		} else {
			System.out.println("Your Cart Is empty");
		}
		System.out.println("TotalAmount =>" + TotalAmount);
		System.out.println("1->Update Cart");
		System.out.println("2->Place Order");
		System.out.println("Select Option to Perform action");
		String userUpdateCartOrPlaceOrderValue = userInput.nextLine();
		int convertUserUpdateCartOrPlaceOrderValue = Integer
				.parseInt(userUpdateCartOrPlaceOrderValue);
		switch (convertUserUpdateCartOrPlaceOrderValue) {
		case 1:
			System.out
					.println("Enter Product Id You Want To Update Like 1,2 etc");
			String userInputProductId = userInput.nextLine();
			int convertUserInputProductId = Integer
					.parseInt(userInputProductId);
			System.out
					.println("Enter Total Quntity You Want in Cart Like 12,24");
			String userInputProductQunity = userInput.nextLine();
			int convertuserInputProductQunity = Integer
					.parseInt(userInputProductQunity);
			int updateResult = updateProductToCart(convertUserInputProductId,
					convertuserInputProductQunity);
			if (updateResult == 1) {
				genrateBillOfCart(cartContainProductName,
						cartContainProductQunity);

			}
			break;
		case 2:
			System.out.println("Your Order Is Placed");
			System.out.print("Total Amoutnt is->" + TotalAmount);
			break;
		default:
			System.out.println("Please Insert Valid");
			genrateBillOfCart(cartContainProductName, cartContainProductQunity);

		}

	}

}
