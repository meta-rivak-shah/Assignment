package get2019.assignment7;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class getTransposeTestCase {
	
	private int[][] inputArray;
	private int[][] expectedResult;
	private static Sparse Sparse;

	@Before
	public void initialize() {
		Sparse = new Sparse(new int[][]{{1,1,3,0,4},{1,0,0,0,0},{0,0,0,0,0},{0,2,6,0,0}});
	}

	public getTransposeTestCase(int[][] expectedResult) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{  new int[][] {{1,1,0,0},{1,0,0,2},{3,0,0,6},{0,0,0,0},{4,0,0,0}}}
	});
	}
	@Test
	public void testMaxMirror() {
		
		assertArrayEquals(expectedResult, Sparse.getTranspose(Sparse.getMatrix()));
	}
}

