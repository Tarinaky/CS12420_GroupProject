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
		
		Classes testClass = new Classes("testClass");

		testDesign.addClass(testClass);
		Classes retrievedClass = testDesign.getClass("testClass");
		
		assertTrue(testClass == retrievedClass);
		
		testDesign.removeClass("TestClass1");
	}

	public void testRenameClass() {
		//Add a class and then rename it.
		testDesign.addClass(new Classes("TestClass-1") );
		testDesign.getClass("TestClass-1").rename("TestClass-2",testDesign);
		testDesign.removeClass("TestClass-2");
	}
}
