package get2019.assignment4;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LinearSearchTestCase {
	private int[] input1;
	private int input2;
	private int expectedResult;
	private SearchAlgo SearchAlgo;

	@Before
	public void initialize() {
		SearchAlgo = new SearchAlgo();
	}

	public LinearSearchTestCase(int expectedResult, int input1[], int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 3, new int[]{1,2,3,4,5,6,7},4}, { 3, new int[]{1,2,3,4,5,6,7},4},
				{ 3, new int[]{1,2,3,4,5,6,7},4}, {-1, new int[]{3,2,3,4,2,6,7},9}, { 4, new int[]{0,2,1,3,4,6,7},4}  , {-1, new int[]{},4 } });
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult , SearchAlgo.linearSearch(input1, input2));
	}
}
