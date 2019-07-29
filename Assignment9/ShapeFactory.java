package com.metacube.get2019;

import java.util.ArrayList;

import com.metacube.get2019.Shape.ShapeType;

/**
 * It is class used to get objects of shape type.
 * @author Rivak shah
 *
 */
public class ShapeFactory {
	static int id = 0;
	
	/**
	 * It is a method used to get object of type shape.
	 * @param shapeName name of shape
	 * @param p point i.e. origin
	 * @param list1 list of parameters
	 * @return shape type object
	 */
	public Shape createShape(String shapeName, Point p, List<Integer> list1) {
		
		Enum ShapeEnum = Enum.valueOf(ShapeType.class, shapeName.toUpperCase() );
		if (ShapeEnum == null) {
			return null;
		}
		if (ShapeEnum == ShapeType.CIRCLE) {
			return new Circle(list1.get(0), p, id++);

		} else if (ShapeEnum == ShapeType.RECTANGLE) {
			return new Rectangle(list1.get(0), list1.get(1), p, id++);

		} else if (ShapeEnum == ShapeType.TRIANGLE) {
			return new Triangle(list1.get(0), list1.get(1), list1.get(2), p, id++);
		}

		return null;
	}
}
