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
		testClasses.add_lnk(link);
		classB.add_lnk(link);

		testClasses.get_lnk("TestLink-1");
		testClasses.rm_lnk("TestLink-1");
	}

	public void testComments() {
		//Add a comment, then retrieve it.
		testClasses.set_comment("Test comment.");
		testClasses.get_comment();
	}

	public void testAddField() {
		//Add a field, retrieve and delete it.
		testClasses.add_field(new Field("TestField-1") );
		testClasses.get_field("TestField-1");
		testClasses.rm_field("TestField-1");
	}

	public void testRenameField() {
		//Add a field, rename it then remove it.
		testClasses.add_field(new Field("TestField-1") );
		testClasses.get_field("TestField-1").rename("TestField-2",testClasses);
		testClasses.rm_field("TestField-2");
	}
}
