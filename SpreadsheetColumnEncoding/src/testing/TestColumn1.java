package testing;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestColumn1 {

	@Test
	public final void testConvertPositive() {
		code.SCencoding test = new code.SCencoding();
		assertTrue("A is 1", test.convert("A") == 1);
		assertTrue("AA is 27", test.convert("AA") == 27);
		assertTrue("AAA is 703", test.convert("AAA") == 703); 
		assertTrue("Z is 26", test.convert("Z") == 26);
		assertTrue("AA{ is 27", test.convert("AA{") == 27);
		assertTrue("A{Z is 53", test.convert("A{Z") == 52);
		assertTrue("{Z is 26", test.convert("{Z") == 26);
		}

	@Test
	public final void testConvertNegative() {
		code.SCencoding test = new code.SCencoding();
		assertFalse("A is a different value than 1", test.convert("A") != 1);
		assertFalse("AA is a different value than 27", test.convert("AA") != 27);
		assertFalse("Z is a different value than 26", test.convert("Z") != 26);
		assertFalse("AA{ is a different value than 27", test.convert("AA{") != 27);
		assertFalse("A{A is a different value than 27", test.convert("A{A") != 27);
		assertFalse("{Z is a different value than 26", test.convert("{Z") != 26);
	}
}
