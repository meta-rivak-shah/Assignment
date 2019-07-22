package get2019.assignment6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ getComplementTestCase.class, getUnionTestCase.class,
		IntSetTestCases.class, isMemberTestCase.class, isSubSetTestCase.class })
public class AllTests {

}
