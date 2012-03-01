package model;
import junit.framework.*;
import junit.framework.Assert.*;

public class AccessModifierTest extends TestCase {
	private AccessModifier testAccessModifier;

	public void setUp() {
	}

	public void testSetGet() {
		testAccessModifier = new AccessModifier(AccessModifier.PUBLIC);
		assertTrue(testAccessModifier.mode == AccessModifier.PUBLIC);

		testAccessModifier = new AccessModifier(AccessModifier.PRIVATE);
		assertTrue(testAccessModifier.mode == AccessModifier.PRIVATE);
	}
}
