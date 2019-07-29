package com.metacube.get2019;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * It is a class with main method
 * @author Rivak shah
 *
 */
public class ShapeFactoryPattern {
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * It is a main method
	 * @param args unused
	 */
	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		List<Integer> parameter = new ArrayList<Integer>();
		List<Integer> parameter1 = new ArrayList<Integer>();
		List<Shape> isEncloseList = new ArrayList<Shape>();
		List<Shape> tempList = new ArrayList<Shape>();

		Screen s = new Screen();
		boolean isExit = false;
		boolean result;
		Point p;
		int x, y;
		try {
			do {
				System.out.println("--------------------------------");
				System.out.println("1. Add object on screen");
				System.out.println("2. Delete a particular object from the screen");
				System.out.println("3. Delete all objects of specific type from screen");
				System.out.println("4. Show all the objects on the screen sorted on the basis of perimeter");
				System.out.println("5. Show all the objects on the screen sorted on the basis of area");
				System.out.println("6. Check position of a point relative to the shape ");
				System.out.println("7. Exit");
				System.out.println("--------------------------------");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				System.out.println("--------------------------------");
				switch (choice) {
				case 1:
					System.out.print("Enter the shape to be added among Rectangle, Circle and Square :");
					sc.nextLine();
					String shapeName = sc.nextLine();
					System.out.println("--------------------------------");
					System.out.print("Enter origin co-ordinates x and y respectively : ");
					x = sc.nextInt();
					y = sc.nextInt();
					p = new Point(x, y);
					parameter1 = getParameter( shapeName, parameter);
					Shape shape1 = shapeFactory.createShape(shapeName, p, parameter1);
					result = s.addObject(shape1);
					System.out.println("--------------------------------");
					System.out.println("Object is added : "+result);
					System.out.println("--------------------------------");
					break;
				case 2:
					System.out.print("Enter the id of shape which you want to delete : ");
					int shapeId = sc.nextInt();
					result = s.deleteObject(shapeId);
					System.out.println("--------------------------------");
					System.out.println("Object is deleted : "+result);
					System.out.println("--------------------------------");
					break;
				case 3:
					System.out.print("Enter the name of shape to be deleted from screen among Rectangle, Circle and Square :");
					sc.nextLine();
					shapeName = sc.nextLine();
					result = s.deleteAllObj(shapeName);
					System.out.println("--------------------------------");
					System.out.println("All objects of shape deleted : "+result);
					System.out.println("--------------------------------");
					break;
				case 4:
					tempList = s.sortAccPerimeter();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to perimeter : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println(tempList.get(i).getId()+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;
				case 5:
					tempList = s.sortAccArea();
					if (tempList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("Sorted list according to area : ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("--------------------------------");
					for (int i = 0; i < tempList.size(); i++) {
						System.out.println(tempList.get(i).getId()+"\t\t"+tempList.get(i).getShapeType());
					}
					System.out.println("--------------------------------");
					break;
				case 6:
					System.out.print("Enter co-ordinates of point x and y respectively : ");
					x = sc.nextInt();
					y = sc.nextInt();
					p = new Point(x, y);
					isEncloseList  = s.isPointEnclosedInShape(p);
					if (isEncloseList.size() == 0) {
						System.out.println("No shapes are in the list!!!");
						break;
					}
					System.out.println("List of shapes which enclosed this list are :  ");
					System.out.println("---------------------------------");
					System.out.println("ID\t\tSHAPETYPE");
					System.out.println("---------------------------------");
					for (int i = 0; i < isEncloseList.size(); i++) {
						System.out.println(isEncloseList.get(i).getId()+"\t\t"+isEncloseList.get(i).getShapeType());
					}
					System.out.println("---------------------------------");
					break;
				case 7:
					isExit = true;
					System.out.println("---------------------------------");
					System.out.println("Exit");
					System.out.println("---------------------------------");
					break;
				default:
					System.out.println("---------------------------------");
					System.out.println("Invalid input");
					System.out.println("---------------------------------");
				}
	
			} while (!isExit);
		}catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
	}

	private static List<Integer> getParameter(String shapeName, List<Integer> parameter) {
		shapeName = shapeName.toUpperCase();
		switch (shapeName) {
		case "CIRCLE":
			System.out.print("Enter radius of circle : ");
			int radius = sc.nextInt();
			parameter.add(0, radius);
			break;
		case "RECTANGLE":
			System.out.print("Enter height and base of rectangle respectively : ");
			int height = sc.nextInt();
			int base = sc.nextInt();
			parameter.add(0, height);
			parameter.add(1, base);
			break;
		case "TRIANGLE":
			System.out.print("Enter side1, side2 and side3 of triangle respectively : ");
			int side1 = sc.nextInt();
			int side2 = sc.nextInt();
			int side3 = sc.nextInt();
			parameter.add(0, side1);
			parameter.add(1, side2);
			parameter.add(2, side3);
			break;
		default :
			System.out.println("Shape invalid");
		}
		return parameter;
	}
}
