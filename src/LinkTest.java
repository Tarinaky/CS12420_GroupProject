import junit.framework.*;
import junit.framework.Assert.*;

public class LinkTest extends TestCase {
	private Link testLink;

	public void setUp() {
		testLink = new Link("test");
		(new Classes("classA") ).add_lnk(testLink);
		(new Classes("classB") ).add_lnk(testLink);
	}

	public void testRename() {
		testLink.rename("test2");
	}

	public void testCardinality() {
		testLink.set_cardinality(Link.CARDINALITY_ONE,Link.CARDINALITY_MANY);
		testLink.get_cardinalityA();
		testLink.get_cardinalityB();
	}

	public void testSetClasses() {
		testLink.set_classA(new Classes("testC") );
		testLink.set_classB(new Classes("testD") );
	}

}

