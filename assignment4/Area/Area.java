package gate2019.assignment;
/**
 * @author Rivak shah
 * @class Area the class area have operation like 
 * @func areaOfRectangle
 * @func areaOfSquare
 * @func areaOfRadius
 * @func areaOfRadius
 * we are calculating all this operation in it
 */
public class Area {
	
	/**
	 * 
	 * @param length2 take length of rectangle
	 * @param width2 take width of rectangle
	 * @return the result=length*width in float
	 * also include ArithmeticException if value divide by zero
	 */
	public float areaOfRectangle(float length2, float width2) {
		float reuslt = (float) 0.0;
		try {
			 reuslt = length2*width2;
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		return reuslt;
	}
	
	
	/**
	 * 
	 * @param side take side of Square
	 * @return the result=side*side in float
	 * also include ArithmeticException in it
	 */
	public float areaOfSquare(float side) {
		float reuslt=(float) 0.0;
		try {
			reuslt = side*side;
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		return reuslt;
	}
	
	/**
	 * 
	 * @param radius take radius of Square
	 * @return the result=radius*radius*3.14 in float
	 * also include ArithmeticException in it if divide by zero
	 */
	public float areaOfRadius(float radius) {
		float result=(float) 0.0;
		
		try {
			result = (float) (Math.PI*radius*radius);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		return result;
	}
	
	/**
	 * @param radius take height base  of Triangle
	 * @return the result=base*height*0.5 in float
	 * also include ArithmeticException in it if divide by zero
	 */
	public float areaOfTriangle(float height, float base) {
		float result=(float) 0.0;
		try {
			result =  (float) (0.5*height*base);
		} catch (ArithmeticException e) {
			// TODO: handle exception
		}
		return result;
	}


	
	

}
