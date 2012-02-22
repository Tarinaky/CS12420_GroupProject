import junit.framework.*;
import junit.framework.Assert.*;

public class DesignTest extends TestCase {
	private Design testDesign;

	public void setUp() {
		testDesign = new Design();
	}

	public void testEmpty() {}

	public void testAddClass() {
		//Add a new class to the Design and then retrieve it.
		testDesign.add_class(new Classes("TestClass1") );

		testDesign.get_class("TestClass1");

		testDesign.rm_class("TestClass1");
	}
}
