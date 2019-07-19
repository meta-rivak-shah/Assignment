package get2019.assignment4;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;



@RunWith(Parameterized.class)
public class LcmTestCase {
	private int input1;
	private int input2;
	private int expectedResult;
	private LcmAndHcfOfNumbers LcmAndHcfOfNumbers;

	@Before
	public void initialize() {
		LcmAndHcfOfNumbers = new LcmAndHcfOfNumbers();
	}

	public LcmTestCase(int expectedResult, int input1, int input2) {
		this.expectedResult = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 6, 2, 6 }, { 6, 2, 3 },
				{ 30, 30, 15 }, { 0, 0, 0 }, { -1 , -2 , -3}});
	}

	@Test
	public void testMaxMirror() {
		assertEquals(expectedResult, LcmAndHcfOfNumbers.lcmOfNumber(input1, input2));
	}
}
