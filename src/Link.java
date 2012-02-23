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

	public void set_cardinality(int a,int b) {
		/**
		 * Change a link's cardinality.
		 */
		cardinalityA = a;
		cardinalityB = b;
	}

	public int get_cardinalityA() {
		/**
		 * Retrieve the cardinality from one end of the relationship.
		 */
		return 1;
	}

	public int get_cardinalityB() {
		/**
		 * Retrive the cardinality from the other end of the relationship.
		 */
		return 1;
	}

	public void set_classA(Classes classA) {
		/**
		 * Change the class at one end of the relationship.
		 */
		this.classA = classA;
	}

	public void set_classB(Classes classB) {
		/**
		 * Change the class at one end of the relationship.
		 */
		this.classB = classB;
	}




}
