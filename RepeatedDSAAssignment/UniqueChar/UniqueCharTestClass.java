package session2019;

import static org.junit.Assert.*;

import org.junit.Test;


public class UniqueCharTestClass {
	UniqueCharacter uniqueObj = new UniqueCharacter();

	@Test
	public void test1() {
		int unique = uniqueObj.foundUnique("aaaabbbbababababababbq");
		assertEquals(1, unique);
		assertNotEquals(45, unique);
	}

	@Test(expected = AssertionError.class) 
	public void test2() {
		int unique = uniqueObj.foundUnique("");
		assertEquals(0, unique);
		assertNotEquals(45, unique);
	}
	@Test
	public void test3() {
		int unique = uniqueObj.foundUnique("abcd");
		assertEquals(4, unique);
		assertNotEquals(45, unique);
	}
	@Test
	public void test4() {
		int unique = uniqueObj.foundUnique("aqwertyuiopqwertyuiopqwertyuiopsdfsdfgghhjjkkl");
		assertEquals(2, unique);
		assertNotEquals(45, unique);
	}
}
