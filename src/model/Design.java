package model;
import java.util.*;

public class Design {
	/**
	 * Design is a class describing all of the backend data for a class diagram.
	 */
	private Map<String,Classes> classes;

	public Design() {//Ctor
		classes = new TreeMap<String,Classes>();

	}

	public Classes addClass(Classes add) {
		/**
		 * Add a class to the database.
		 */
		
		String key = add.getLabel();
		classes.put(key, add);
		return add;
	}

	public void removeClass(String label) {
		/**
		 * Remove a class from the database by its label.
		 */
		classes.remove(label);
	}

	public Classes getClass(String label) {
		/**
		 * Return the class associated with a given label.
		 */
		return classes.get(label);
	}
	
	public Map<String,Classes> getAllClasses()
	{
		/**
		 * Return tree map of all classes.
		 */
		return classes;
	}
}
