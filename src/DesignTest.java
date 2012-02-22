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
		testDesign.add_class(new Classes("TestClass-1") );

		testDesign.get_class("TestClass1");

		testDesign.rm_class("TestClass1");
	}

	public void testRenameClass() {
		//Add a class and then rename it.
		testDesign.add_class(new Classes("TestClass-1") );
		testDesign.get_class("TestClass-1").rename("TestClass-2",testDesign);
		testDesign.rm_class("TestClass-2");
	}
}
