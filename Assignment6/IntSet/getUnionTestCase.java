package get2019.assignment6;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class getUnionTestCase{
	
	private int expectedResult[];
	private int set1[];
	private int set2[];
	private static IntSet IntSet2;
	private static IntSet IntSet1;
	@Before
	public void initialize() {
		IntSet1 = new IntSet(new int[]{2,8,9});
		IntSet2 = new IntSet(new int[]{2,3,4,1});
		
	}

	public getUnionTestCase(int expectedResult[],IntSet IntSet1, IntSet  IntSet2) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{new int[]{2,8,9,3,4,1},IntSet1,IntSet2},
	});
	}
	
	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, IntSet1.getUnion(IntSet1, IntSet2));
	}
	
	
}

