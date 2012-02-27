package model;
import java.util.*;
import java.awt.*;

public class Classes implements java.io.Serializable {
	/**
	 * Classes contains data relating to a single class within a class diagram. It holds pointers to all relationships or 'links' associated to the class and also contains miscilaneous 'Fields' for Methods and Primative types.
	 */

	private String label;
	private Map<String,Link> links;
	private String comment;
	private Map<String,Field> fields;
	private Point position; //The position of the class in the graphical panel

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Classes(String label) {
		/** Ctor creating a class with a given String label. The label is used to identify the Class within the design - each must be unique.
		 */
		this.label = label;
		links = new TreeMap<String,Link>();
		comment = new String("");
		fields = new TreeMap<String,Field>();
		position = new Point(50, 50);
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
		String label = link.getLabel();
		links.put(label, link);
	}

	public Link getLink(String label) {
		/**
		 * Retrieve a Link by its label.
		 */
		return links.get(label);
	}

	public void removeLink(String label) {
		/**
		 * Remove a link by its label.
		 */
		links.remove(label);
	}

	public void setComment(String comment) {
		/**
		 * Set this classes' comment string.
		 */
		this.comment = comment;
	}

	public String getComment() {
		/**
		 * Return this classes' comment string.
		 */
		return comment;
	}

	public void addField(Field field) {
		/**
		 * Add a field to this class.
		 */
		String label = field.getLabel();
		fields.put(label, field);
	}

	public Field getField(String label) {
		/**
		 * Retrieve a field by its label. Returns null if no such field exists.
		 */
		return fields.get(label);
	}

	public void removeField(String label) {
		/**
		 * Remove a field by its label.
		 */
		fields.remove(label);
	}
	
	public String getLabel() {
		/**
		 * Return a copy of the string associated with this class.
		 * 
		 * Edit: I just learned that Java's String is immutable, making the use of a
		 * copy-ctor superfluous.
		 */
		return label;
		
	}


}
