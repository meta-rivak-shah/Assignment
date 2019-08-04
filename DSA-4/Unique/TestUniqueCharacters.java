import static org.junit.Assert.*;
import org.junit.Test;


public class TestUniqueCharacters {
	UniqueCharacters object = new UniqueCharacters();

	@Test
	public void test() {
		String string1 = "hello";
		assertEquals(3, object.getUniqueCharactersInAString(string1));
		
		String string2 = "surender";
		assertEquals(4, object.getUniqueCharactersInAString(string2));
		
		String string3 = "sengwa";
		assertEquals(6, object.getUniqueCharactersInAString(string3));
		
		String string4 = "hello";
		assertEquals(3, object.getUniqueCharactersInAString(string4));
	}
}
