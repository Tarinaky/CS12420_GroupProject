public class Link {
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

	public void rename(String label) {
		/**
		 * Change a link's name.
		 */
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
		return 1;
	}

	public int getCardinalityB() {
		/**
		 * Retrive the cardinality from the other end of the relationship.
		 */
		return 1;
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
		 * This should not be used to rename a link, hence the return of a copy only.
		 */
		return new String(label);
	}


}
