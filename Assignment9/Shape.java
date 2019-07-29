package com.metacube.get2019;

/**
 * It is an interface.
 * @author Rivak shah

 *
 */
public interface Shape {
	
	public static int id = 0;
	
	enum ShapeType{
		RECTANGLE, TRIANGLE, CIRCLE;
	}
	
	
	public int getArea();
	public int getPerimeter();
	public Point getOrigin();
	public boolean isPointEnclosed(Point p);
	public ShapeType getShapeType();
	public int getId();
}

