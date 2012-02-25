import junit.framework.*;
import junit.framework.Assert.*;

import java.util.*;

public class MethodTest extends TestCase {
	private Method testMethod;

	public void setUp() {
		testMethod = new Method("method");
	}

	public void testParameters() {
		testMethod.setParameters(new ArrayList<Field>() );
		testMethod.getParameters().add(new Field("arg1") );
	}
}
