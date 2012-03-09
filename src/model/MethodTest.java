package model;
import junit.framework.*;
import junit.framework.Assert.*;

import java.util.*;

public class MethodTest extends TestCase {
	private Method testMethod;

	public void setUp() {
		testMethod = new Method("method");
	}

	public void testParameters() {
		
		assertTrue(testMethod.getParameters().isEmpty() );
		
		Field testField = new Field("testField");
					
		testMethod.getParameters().add(testField);
		assertTrue(testMethod.getParameters().contains(testField) );
		
		testMethod.getParameters().add(new Field("arg1") );
		
	}
}
