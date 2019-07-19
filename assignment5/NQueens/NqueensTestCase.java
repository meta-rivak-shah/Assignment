package get2019.assignment4;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class NqueensTestCase {
	
	private int[][] inputArray;
	private int[][] expectedResult;
	private Nqueens Nqueens;

	@Before
	public void initialize() {
		Nqueens = new Nqueens();
	}

	public NqueensTestCase(int[][] expectedResult, int[][] inputArray) {
	this.expectedResult = expectedResult;
	this.inputArray = inputArray;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
	return Arrays.asList(new Object[][] {
	{  new int[][] {{0,0,1,0},{1,0,0,0},{0,0,0,1},{0,1,0,0}}, new int[][] { {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}},
	{  new int[][] {{0,0,0},{0,0,0},{0,0,0}}, new int[][] { {0,0,0},{0,0,0},{0,0,0}}}

	});
	}
	@Test
	public void testMaxMirror() {
		
		assertArrayEquals(expectedResult, Nqueens.printElement(inputArray));
	}
}

