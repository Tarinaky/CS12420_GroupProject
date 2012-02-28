package model;
import junit.framework.*;
import junit.framework.Assert.*;

public class DesignTest extends TestCase {
	private Design testDesign;

	public void setUp() {
		testDesign = new Design();
	}
	
	public void testWriteLoad() throws Exception {
		//Serializes a dummy Design to file, and then deserializes it.
		testDesign.addClass(new Classes("testClass"));
		testDesign.getClass("testClass").addField(new Field("testField"));
		
		testDesign.saveTo("testSave.ser");
		testDesign = Design.loadFrom("testSave.ser");
		
		assertTrue(testDesign.getClass("testClass").getField("testField") != null);
	}

	public void testExport() throws Exception {
		//Writes out a dummy class to dummy.java.
		testDesign.addClass(new Classes("dummy") );

		testDesign.exportToFolder(new java.io.File(".") );
	}

	public void testAddClass() {
		//Add a new class to the Design and then retrieve it.
		
		Classes testClass = new Classes("testClass");

		testDesign.addClass(testClass);
		Classes retrievedClass = testDesign.getClass("testClass");
		
		assertTrue(testClass == retrievedClass);
	}
	
	public void testRemoveClass() {
		testDesign.addClass(new Classes("testClass") );
		testDesign.removeClass("testClass");
		
		assertTrue(testDesign.getClass("testClass") == null);
	}

	public void testRenameClass() {
		//Add a class and then rename it.
		/*testDesign.addClass(new Classes("TestClass-1") );
		testDesign.getClass("TestClass-1").rename("TestClass-2",testDesign);
		testDesign.removeClass("TestClass-2");*/
		Classes testClass = new Classes("testClass");
		
		testDesign.addClass(testClass);
		testDesign.getClass("testClass").rename("renamedClass", testDesign);
		
		assertTrue(testDesign.getClass("testClass") == null);
		assertTrue(testDesign.getClass("renamedClass") == testClass);
	}
}
