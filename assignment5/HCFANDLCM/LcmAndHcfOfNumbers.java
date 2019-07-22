package get2019.assignment4;
/*
 * @class LcmAndHcfOfNumbers contain some basic operation like
 * @func LcmAndHcfOfNumbers
 * @func hcfOfNumber
 * @param lcm is use to find the lcm of number
 * @param reminder is contain reminder when we take modules
 */
public class LcmAndHcfOfNumbers {
	private int lcm=1;
	private int reminder=-1;
	/*
	 * this function is used to find the lcm of number 
	 * @param a contain first number
	 * @param b contain second number
	 * @return lcm of number if exist else -1;
	 */
	int lcmOfNumber(int a , int b)
	{
		try {
			   int c = a + b;
			   if( c < 0){
				   return -1;
			   }
			   if( lcm % a == 0 &&  lcm % b == 0) {
			    	return lcm;
		    	}
				lcm++;
				return lcmOfNumber(a, b);  //recursion call until when lcm is completely divided by both a and b
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	/*
	 * this function is used to find the Hcf of number 
	 * @param x contain first number
	 * @param y contain second number
	 * @return hcf of number if exist else -1;
	 */
	int hcfOfNumber(int x , int y)
	{
		try {
			if( x <= -1 || y <= -1 ){
				return -1;
			}
			if(x < y) {
				int temp = x;
				x = y;
				y = temp;
			}  
			if(reminder != 0) {
				reminder = x % y;
				if(reminder == 0){
					return y;
				}
				x = y;
				y = reminder;
				return hcfOfNumber( x , y); // recursion call until when reminder !=0 when 0 return hcf
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return y;
	}
	
}