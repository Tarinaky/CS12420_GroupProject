import junit.framework.*;
import junit.framework.Assert.*;

public class FieldTest extends TestCase {
	private Field testField;

	public void setUp() {
		testField = new Field("test");
	}

	public void testAccessModifiers() {
		testField.set_am(AccessModifier.PUBLIC);
		testField.set_am(AccessModifier.PROTECTED);
		testField.set_am(AccessModifier.PRIVATE);
		testField.get_am();
	}

	public void testType() {
		testField.set_type("Foo");
		testField.get_type();
	}
}
