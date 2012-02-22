import java.util.*;

public class Classes {
	/**
	 * Classes contains data relating to a single class within a class diagram. It holds pointers to all relationships or 'links' associated to the class and also contains miscilaneous 'Fields' for Methods and Primative types.
	 */

	private String label;
	private Map<String,Link> links;
	private String comment;
	private Map<String,Field> fields;

	public Classes(String label) {
		/** Ctor creating a class with a given String label. The label is used to identify the Class within the design - each must be unique.
		 */
		this.label = label;
		links = new TreeMap<String,Link>();
		comment = new String("");
		fields = new TreeMap<String,Field>();
	}
}
