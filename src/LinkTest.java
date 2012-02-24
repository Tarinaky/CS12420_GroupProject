import junit.framework.*;
import junit.framework.Assert.*;

public class LinkTest extends TestCase {
	private Link testLink;

	public void setUp() {
		testLink = new Link("test");
		(new Classes("classA") ).addLink(testLink);
		(new Classes("classB") ).addLink(testLink);
	}

	public void testRename() {
		testLink.rename("test2");
	}

	public void testCardinality() {
		testLink.setCardinality(Link.CARDINALITY_ONE,Link.CARDINALITY_MANY);
		testLink.getCardinalityA();
		testLink.getCardinalityB();
	}

	public void testSetClasses() {
		testLink.setClassA(new Classes("testC") );
		testLink.setClassB(new Classes("testD") );
	}

}

