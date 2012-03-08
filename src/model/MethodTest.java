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
		
		assertTrue(testMethod.getParameters().isEmpty());
		
		Field testField = new Field("testField");
					
		testMethod.addParameter(testField);
		assertTrue(testMethod.getParameter("testField")==testField);
				
		testMethod.addParameter(new Field("arg1"));
		
	}
}
