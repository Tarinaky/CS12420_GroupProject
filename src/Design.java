import java.util.*;

public class Design {
	/**
	 * Design is a class describing all of the backend data for a class diagram.
	 */
	private Map<String,Classes> classes;

	public Design() {//Ctor
		classes = new TreeMap<String,Classes>();

	}

	public void add_class(Classes add) {
		/**
		 * Add a class to the database.
		 */
	}

	public void rm_class(String label) {
		/**
		 * Remove a class from the database by its label.
		 */
	}

	public void get_class(String label) {
		/**
		 * Return the class associated with a given label.
		 */
	}
}
