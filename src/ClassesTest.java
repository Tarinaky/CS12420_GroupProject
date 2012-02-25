import junit.framework.*;
import junit.framework.Assert.*;

public class ClassesTest extends TestCase {
	private Classes testClasses;

	public void setUp() {
		testClasses = new Classes("testClasses");
	}

	public void testAddLink() {
		//Add a link to the class, retrieve it and remove it.
		Classes classB = new Classes("classB");
		Link link = new Link("link");
		
		link.setClassA(testClasses);
		link.setClassB(testClasses);
		
		//Assert that both classes point to the same link.
		assertTrue(testClasses.getLink("link") == classB.getLink("link") );
	}

	public void testComments() {
		//Add a comment, then retrieve it.
		String testComment = new String();
		
		testClasses.setComment(testComment);
		assertTrue(testClasses.getComment() == testComment);
		
	}

	public void testAddField() {
		//Add a field, retrieve and delete it.
		Field testField = new Field("testField");
		
		testClasses.addField(testField);
		
		assertTrue(testClasses.getField("testField") == testField);
		
	}
	
	public void testRemoveField() {
		testClasses.addField(new Field("testField") );
		testClasses.removeField("testField");
		
		assertTrue(testClasses.getField("testField") == null);
	}

	public void testRenameField() {
		//Add a field, rename it then verify it.
		
		Field testField = new Field("testField");
		
		testClasses.addField(testField);
		testClasses.getField("testField").rename("renamedField", testClasses);
		
		assertTrue(testClasses.getField("testField") == null);
		assertTrue(testClasses.getField("renamedField") == testField);
	}
}
