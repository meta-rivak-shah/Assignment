package get2019.assignment6;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class getComplementTestCase{
	
	private int expectedResult[];
	private int value[];
	private IntSet IntSet1;
	@Before
	public void initialize() {
		IntSet1 = new IntSet(new int[]{1,2,3,4,5,6,7,8,9});
	}

	public getComplementTestCase(int expectedResult[], int value[]) {
	this.expectedResult = expectedResult;
	this.value = value;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data1() {
	return Arrays.asList(new Object[][] {
	{new int[]{9},new int[]{1,2,3,4,5,6,7,8}},
	{new int[]{4,9},new int[]{1,2,3,5,6,7,8}}
	});
	}
	
	@Test
	public void testIntSet1() {
		assertArrayEquals(expectedResult, IntSet1.getComplement(value));
	}
	
	
}

