package get2019.assignment7;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class findSymetricTestCase {
	
	private int[][] inputArray;
	private boolean expectedResult;
	private static Sparse Sparse;

	@Before
	public void initialize() {
		Sparse = new Sparse(new int[][]{{2,0,1},{0,1,0},{1,0,2}});
	}

	public findSymetricTestCase(boolean expectedResult) {
	this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{true}
	});
	}
	@Test
	public void testMaxMirror() {
		
		assertEquals(expectedResult, Sparse.findSymetric(Sparse.getMatrix()));
	}
}

