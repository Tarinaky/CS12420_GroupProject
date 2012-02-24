import junit.framework.*;
import junit.framework.Assert.*;

public class ClassesTest extends TestCase {
	private Classes testClasses;

	public void setUp() {
		testClasses = new Classes("test");
	}

	public void testAddLink() {
		//Add a link to the class, retrieve it and remove it.
		Classes classB = new Classes("classB");
		Link link = new Link("link");
		testClasses.addLink(link);
		classB.addLink(link);

		testClasses.getLink("TestLink-1");
		testClasses.removeLink("TestLink-1");
	}

	public void testComments() {
		//Add a comment, then retrieve it.
		testClasses.setComment("Test comment.");
		testClasses.getComment();
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
