package model;
public class Link implements java.io.Serializable {
	/**
	 * Describes a relationship between two classes.
	 */

	private String label;
	private int cardinalityA,cardinalityB;
	
	public static int CARDINALITY_ONE = 1;
	public static int CARDINALITY_MANY = -1;
	public static int INHERITANCE = 0;

	private Classes classA,classB;

	public Link(String label) {
		/**
		 * Create a new link.
		 */
		this.label = label;
	}
	
	public Link(String label, Classes classA, Classes classB, int cardinalityA, int cardinalityB) {
		/**
		 * Create a new link.
		 */
		this.label = label;
		this.classA = classA;
		this.classB = classB;
		this.cardinalityA = cardinalityA;
		this.cardinalityB = cardinalityB;
	}

	public void rename(String label) {
		/**
		 * Change a link's name.
		 */
		String oldLabel = this.label;
		this.label = label;
		
		classA.removeLink(oldLabel);
		classA.addLink(this);
		
		classB.removeLink(oldLabel);
		classB.addLink(this);
		
	}

	public void setCardinality(int a,int b) {
		/**
		 * Change a link's cardinality.
		 */
		cardinalityA = a;
		cardinalityB = b;
	}

	public int getCardinalityA() {
		/**
		 * Retrieve the cardinality from one end of the relationship.
		 */
		return cardinalityA;
	}

	public int getCardinalityB() {
		/**
		 * Retrive the cardinality from the other end of the relationship.
		 */
		return cardinalityB;
	}

	public void setClassA(Classes classA) {
		/**
		 * Change the class at one end of the relationship.
		 */
		Classes old = this.classA;
		
		if (old != null) {
			old.removeLink(getLabel() );
		}
		
		this.classA = classA;
		classA.addLink(this);
	}

	public void setClassB(Classes classB) {
		/**
		 * Change the class at one end of the relationship.
		 */
		Classes old = this.classB;
		
		if (old != null) {
			old.removeLink(getLabel() );
		}
		
		this.classB = classB;
		classB.addLink(this);
	}

	public String getLabel() {
		/**
		 * Returns a copy of this link's label.
		 * Edit: Just learned that String is immutable. No need for a copy.
		 */
		return label;
	}

	public Classes getClassA() {
		return classA;
	}

	public Classes getClassB() {
		return classB;
	}


}

