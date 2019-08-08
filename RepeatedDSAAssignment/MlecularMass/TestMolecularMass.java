package session2019;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMolecularMass {
	MolecularMass MolecularMassObj = new MolecularMass();

	@Test
	public void test1() {
		int unique = MolecularMassObj.calculateMolecularMass("((()))");
		assertEquals(0, unique);
		assertNotEquals(45, unique);
	}

	@Test(expected = AssertionError.class) 
	public void test2() {
		int unique = MolecularMassObj.calculateMolecularMass(null);
		assertEquals(0, unique);
		assertNotEquals(45, unique);
	}
	@Test(expected = AssertionError.class) 
	public void test3() {
		int unique = MolecularMassObj.calculateMolecularMass("");
		assertEquals(0, unique);
		assertNotEquals(45, unique);
	}
	@Test
	public void test5() {
		int unique = MolecularMassObj.calculateMolecularMass("(ch2(ch2(ch2)ch2)ch2)2");
		assertEquals(140, unique);
		assertNotEquals(45, unique);
	}
	@Test
	public void test6() {
		int unique = MolecularMassObj.calculateMolecularMass("(ch2)");
		assertEquals(14, unique);
		assertNotEquals(45, unique);
	}
	@Test
	public void test7() {
		int unique = MolecularMassObj.calculateMolecularMass("(ch2ch3ch4(ch3))2");
		assertEquals(120, unique);
		assertNotEquals(45, unique);
	}
	
	
}
