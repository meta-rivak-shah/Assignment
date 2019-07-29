package get2019.assignment7;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class multiPication {
	
	private int[][] inputArray;
	private int[][] expectedResult;
	private static Sparse Sparse;
	private static Sparse Sparse1;

	@Before
	public void initialize() {
		Sparse = new Sparse(new int[][]{{2,0,1},{0,1,0},{1,0,2}});
		Sparse1 = new Sparse(new int[][]{{2,0,1},{0,1,0},{1,0,2}});
	}

	public findAddtionTestCase(int[][] expectedResult) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{new int[][]{{4,4,4},{0,3,3},{0,0,4}}}
	});
	}
	@Test
	public void testMaxMirror() {
		
		assertEquals(expectedResult, Sparse.multiPication(Sparse.getMatrix(),Sparse1.getMatrix()));
	}

}


