package com.metacube.get2019;

import com.metacube.get2019.Shape.ShapeType;

/**
 * It is a rectangle class used to implement shape interface.
 * @author Rivak shah
 *
 */
public class Rectangle implements Shape {
	private int height, base;
	private Point origin;
	private int shapeId;

	private static final Shape.ShapeType shapeType = ShapeType.RECTANGLE; 

	/**
	 * It is an conctructor used to initialize rectangle class attributes.
	 * @param height height of rectangle
	 * @param base base of rectangle
	 * @param origin origin of rectangle
	 * @param shapeId
	 */
	public Rectangle( int height, int base, Point origin, int shapeId) {
		this.height = height;
		this.base = base;
		this.origin = origin;
		this.shapeId = shapeId;
	}
	
	/**
	 * it is method used to get area of rectangle.
	 * @return area of rectangle.
	 */
	public int getArea() {
		int area = height * base;
		return area;
	}
	
	/**
	 * It is method used to return perimeter of rectangle.
	 * @return perimeter of rectangle
	 */
	public int getPerimeter() {
		 int perimeter = 2 * ( height + base);
		 return perimeter;
	}
	
	/**
	 * It is a method used to return origin of rectangle.
	 * @return origin
	 */
	public Point getOrigin(){
		return origin;
	}
	
	/**
	 * It is used to get id.
	 * @return id
	 */
	public int getId() {
		return shapeId;
	}
	
	/**
	 * It is a method used to return shapeType.
	 * @return shapeType
	 */
	public Shape.ShapeType getShapeType() {
		return shapeType;
	}
	
	/**
	 * It is a method used to check whether a point isenclosed in rectangle.
	 * @param p point to be check.
	 * @return boolean value
	 */
	public boolean isPointEnclosed(Point p) {
		if (p.x >= origin.x && p.x <= ( origin.x + base ) && p.y >= origin.y && p.y <= (origin.x + height) )
		{
			return true;
		}
		return false;
	}
}
