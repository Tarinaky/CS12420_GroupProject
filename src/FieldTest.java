import junit.framework.*;
import junit.framework.Assert.*;

public class FieldTest extends TestCase {
	private Field testField;

	public void setUp() {
		testField = new Field("test");
	}

	public void testAccessModifiers() {
		testField.setAccessModifier(AccessModifier.PUBLIC);
		testField.setAccessModifier(AccessModifier.PROTECTED);
		testField.setAccessModifier(AccessModifier.PRIVATE);
		testField.getAccessModifier();
	}

	public void testType() {
		testField.setType("Foo");
		testField.getType();
	}
}
