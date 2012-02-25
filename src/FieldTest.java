import junit.framework.*;
import junit.framework.Assert.*;

public class FieldTest extends TestCase {
	private Field testField;

	public void setUp() {
		testField = new Field("test");
	}

	public void testAccessModifiers() {
		testField.setAccessModifier(AccessModifier.PRIVATE);
		assertTrue(testField.getAccessModifier() == AccessModifier.PRIVATE);
	}

	public void testType() {
		String testString = new String();
		testField.setType(testString);
		assertTrue(testField.getType() == testString);
	}
}
