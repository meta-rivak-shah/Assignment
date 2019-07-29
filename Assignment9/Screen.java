package com.metacube.get2019;

import java.util.ArrayList;
import java.util.List;

import com.metacube.get2019.Shape.ShapeType;

/**
 * It is a class used to implement operation on screen
 * @author Rivak shah
 *
 */
public class Screen {
	
	List<Shape> shapeObj = new ArrayList<Shape>(); 	
	
	/**
	 * It is a method used to add object on the screen
	 * @param obj shape type object
	 * @return boolean value
	 */
	public boolean addObject(Shape obj) {
		shapeObj.add(obj);
		return true;
	}

	/**
	 * It is a method used to delete a particular object from screen
	 * @param id id of object to be deleted.
	 * @return boolean value
	 */
	public boolean deleteObject(int id) {
		if (shapeObj.size() == 0) {
			throw new AssertionError("List is empty i.e. there is no object.");
		}
		for (int i = 0; i < shapeObj.size(); i++) {
			if (shapeObj.get(i).getId() == id) {
				shapeObj.remove(i);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * It is a method used to delete all object of a specific shape type.
	 * @param shapeName name of shape to be deleted.
	 * @return boolean value.
	 */
	public boolean deleteAllObj(String shapeName) {
		shapeName = shapeName.toUpperCase();
		Shape.ShapeType ShapeEnum = Shape.ShapeType.valueOf(shapeName);
		if (shapeObj.size() == 0) {
			throw new AssertionError("List is empty i.e. there is no object.");
		}
		for (int i = 0; i < shapeObj.size(); i++) {
			if (shapeObj.get(i).getShapeType() == ShapeEnum) {
				shapeObj.remove(i);
			}
		}
		return true;
	}
	
	/**
	 * It is a method used to return shape object list based on area.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortAccArea() {
		
		for (int i = 0; i < shapeObj.size(); i++) {
			for (int j = 0; j < (shapeObj.size() - i - 1); j++) {
				if (shapeObj.get(j).getArea() > shapeObj.get(j + 1).getArea()) {
					
					Shape temp = shapeObj.get(j);
					shapeObj.set(j, shapeObj.get(j + 1));
					shapeObj.set(j + 1, temp);
				}
			}
		}
		return shapeObj;
	}
	
	/**
	 * It is a method used to return shape object list based on perimeter.
	 * @return sorted list of shape objects
	 */
	public List<Shape> sortAccPerimeter() {
		for (int i = 0; i < shapeObj.size(); i++) {
			for (int j = 1; j < (shapeObj.size() - i); j++) {
				if (shapeObj.get(j - 1).getPerimeter() > shapeObj.get(j).getPerimeter()) {
					
					Shape temp = shapeObj.get(j - 1);
					shapeObj.set(j - 1, shapeObj.get(j));
					shapeObj.set(j, temp);
				}
			}
		}
		return shapeObj;
	}
	
	/**
	 * It is a method used to return a list of shape objects which enclosed given point.
	 * @param p point which we have to check
	 * @return list of shape object.
	 */
	public List<Shape> isPointEnclosedInShape(Point p) {
		List<Shape> isEnclose = new ArrayList<>();
		
		for (int i = 0; i < shapeObj.size(); i++) {
			Shape obj = shapeObj.get(i);
			if (obj.isPointEnclosed(p)) {
				isEnclose.add(obj);
			}
		}
		return isEnclose;
	}
	
	
}

