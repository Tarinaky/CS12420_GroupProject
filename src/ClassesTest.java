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
		testClasses.addField(new Field("TestField-1") );
		testClasses.getField("TestField-1");
		testClasses.removeField("TestField-1");
	}

	public void testRenameField() {
		//Add a field, rename it then remove it.
		testClasses.addField(new Field("TestField-1") );
		testClasses.getField("TestField-1").rename("TestField-2",testClasses);
		testClasses.removeField("TestField-2");
	}
}
