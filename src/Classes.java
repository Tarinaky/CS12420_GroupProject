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

	public void rename(String label, Design design) {
		/**
		 * Rename a class and update the design to reflect it.
		 */
		String oldLabel = this.label;
		this.label = label;
		
		design.removeClass(oldLabel);
		design.addClass(this);
	}

	public void addLink(Link link) {
		/**
		 * Add a link to the Class.
		 */
	}

	public Link getLink(String label) {
		/**
		 * Retrieve a Link by its label.
		 */
		return new Link("Dummy");
	}

	public void removeLink(String label) {
		/**
		 * Remove a link by its label.
		 */
	}

	public void setComment(String comment) {
		/**
		 * Set this classes' comment string.
		 */
	}

	public String getComment() {
		/**
		 * Return this classes' comment string.
		 */
		return new String("");
	}

	public void addField(Field field) {
		/**
		 * Add a field to this class.
		 */
	}

	public Field getField(String label) {
		/**
		 * Retrieve a field by its label.
		 */
		return new Field("Dummy");
	}

	public void removeField(String label) {
		/**
		 * Remove a field by its label.
		 */
	}
	
	public String getLabel() {
		/**
		 * Return a copy of the string associated with this class.
		 * This should -not- be used to rename the class directly, hence the return of a copy.
		 */
		return new String(label);
		
	}


}
