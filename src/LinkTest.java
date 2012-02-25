import junit.framework.*;
import junit.framework.Assert.*;

public class LinkTest extends TestCase {
	private Link testLink;

	public void setUp() {
		testLink = new Link("testLink");
		testLink.setClassA(new Classes("classA") );
		testLink.setClassB(new Classes("classB") );
	}

	public void testCardinality() {
		testLink.setCardinality(Link.CARDINALITY_ONE,Link.CARDINALITY_MANY);
		assertTrue(testLink.getCardinalityA() == Link.CARDINALITY_ONE);
		assertTrue(testLink.getCardinalityB() == Link.CARDINALITY_MANY);
	}

	public void testSetClasses() {
		Classes testC = new Classes("testC");
		Classes testD = new Classes("testD");
		
		testLink.setClassA(testC);
		testLink.setClassB(testD);
		
		assertTrue(testC.getLink("testLink") == testLink);
		assertTrue(testD.getLink("testLink") == testLink);
	}

}

