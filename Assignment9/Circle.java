package com.metacube.get2019;

/**
 * It is a circle class used to implement shape interface.
 * @author Rivak shah
 *
 */
public class Circle implements Shape {
	private int radius;
	private Point origin;
	private static final Shape.ShapeType shapeType = ShapeType.CIRCLE; 
	private int shapeId;
	
	/**
	 * It is constructor used to intialize circle class attributes.
	 * @param radius radius of circle.
	 * @param origin origin of circle.
	 * @param shapeId
	 */
	public Circle( int radius, Point origin, int shapeId) {
		this.radius = radius;
		this.origin = origin;
		this.shapeId = shapeId;
	}
	
	/**
	 * It is a method used to get area of circle.
	 * return area of triangle
	 */
	public int getArea() {
		int area = ( 22 * radius * radius ) / 7;
		return area;
	}
	
	/**
	 * It is a method used to find perimeter of circle.
	 * return perimeter of triangle
	 */
	public int getPerimeter () {
		 int perimeter = ( 2 * 22 * radius ) / 7;
		 return perimeter;
	}
	
	/**
	 * It is method used to return origin of circle.
	 * @return origin.
	 */
	public Point getOrigin( ){
		return origin;
	}

	/**
	 * It is a method used to return shapeType.
	 * @return shapeType
	 */
	public Shape.ShapeType getShapeType() {
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
	 * It is a method used to check whether a point isenclosed in circle.
	 * @param p point to be check.
	 * @return boolean value
	 */
	public boolean isPointEnclosed(Point p) {
		int[] center = getCenter();
		int distance = (int)(Math.sqrt((center[0] - p.x) * (center[0] - p.x) + (center[1] - p.y)* (center[1] - p.y)));
		if (distance <= radius) {
			return true;
		}
		return false;	
	}
	
	public int[] getCenter() {
		int toOriginLen = (int)(Math.sqrt(origin.x * origin.x + origin.y * origin.y));
		int toCenterLen = toOriginLen + radius;
		
		int[] centerPoint = new int[2];
		
		centerPoint[0] = ( toCenterLen * origin.x ) / toOriginLen;
		centerPoint[1] = ( toCenterLen * origin.y ) / toOriginLen;

		return centerPoint;
	}
}
