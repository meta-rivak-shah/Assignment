package com.metacube.get2019;

import com.metacube.get2019.Shape.ShapeType;

/**
 * It is a class triangle used to impelment interface Shape.
 * @author Rivak shah
 *
 */
public class Triangle implements Shape {
	
	private int side1, side2, side3;
	private Point origin;
	private int shapeId;

	private static final ShapeType shapeType = ShapeType.TRIANGLE; 
	
	/**
	 * It is constructor of triangle used to intialize triangle class attributes.
	 * @param side1 side1 of triangle
	 * @param side2 side2 of triangle
	 * @param side3 side3 of triangle
	 * @param origin origin of triangle
	 * @param shapeId
	 */
	public Triangle( int side1, int side2, int side3, Point origin, int shapeId) {
		
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.origin = origin;
		this.shapeId = shapeId;
	}
	
	/**
	 * It is a method used to get area of triangle.
	 * return area of triangle
	 */
	public int getArea() {
		int sum = getPerimeter();
		sum = sum/2;
		int calc = sum * (sum - side1) * (sum - side2) * (sum - side3);
		int area = (int) Math.pow(calc, 0.5);
		return area;
	}
	
	/**
	 * It is a method used to find perimeter of triangle.
	 * return perimeter of triangle
	 */
	public int getPerimeter () {
		 int perimeter = side1 + side2 + side3;
		 return perimeter;
	}
	
	/**
	 * It is method used to return origin of triangle
	 * return origin.
	 */
	public Point getOrigin( ){
		return origin;
	}
	
	/**
	 * It is a method used to return shapeType.
	 * @return shapeType
	 */
	public ShapeType getShapeType() {
		return shapeType;
	}
	
	/**
	 * It is used to get id.
	 * @return id
	 */
	public int getId() {
		return shapeId;
	}
	
	/**
	 * It is a method used to find area using points.
	 * @param x1 
	 * @param y1 
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return area of triangle
	 */
	private int areaThroughPoints(int x1, int y1, int x2, int y2, int x3, int y3) {
		int areaOfTri = (int) Math.abs((x1*(y2-y3) + x2*(y3-y1)+  x3*(y1-y2)) / 2.0); 
		return areaOfTri;
	}
	
	/**
	 * It is a method used to check whether a point isenclosed in triangle.
	 * @param p point to be check.
	 * @return boolean value
	 */
	public boolean isPointEnclosed(Point p) {
		Point p2 = new Point ( origin.x + side1, origin.y);
		Point p3 = new Point();
		p3.x = ((side2 * side2) - (side3 * side3) - (origin.x) + (p2.x)) / (2 * (p2.x) - (origin.x));
		p3.y = ((int)(Math.sqrt((side2 * side2) - ((p3.x - origin.x) * (p3.x - origin.x))))) + origin.y;
		
		int A = getArea();
		int A1 = areaThroughPoints (p.x, p.y, p2.x, p2.y, p3.x, p3.y);
		int A2 = areaThroughPoints (p.x, p.y, p2.x, p2.y, origin.x, origin.y);
		int A3 = areaThroughPoints (p.x, p.y, origin.x, origin.y, p3.x, p3.y);
		return (A == A1 + A2 + A3);
	}
}
