package model;
public class Field {
	/**
	 * Stores information about a (non-Class) Field in a class.
	 */

	private String label;
	private String type;
	private AccessModifier accessModifier;

	public Field(String label) {
		/**
		 * Ctor
		 */
		this.label = label;
		this.type = new String();
		this.accessModifier = new AccessModifier();
	}

	public void rename(String label, Classes classes) {
		/**
		 * Rename the field, and then update classes to reflect the new name.
		 */
		String oldLabel = this.label;
		this.label = label;
		
		classes.removeField(oldLabel);
		classes.addField(this);
	}

	public void setAccessModifier(int am) {
		/**
		 * Set this field's access modifier.
		 */
		this.accessModifier.mode = am;
	}

	public int getAccessModifier() {
		/**
		 * Fetch this field's access modifier. 
		 * Cannot be used for in-situ modification as it is returned by value.
		 */
		return accessModifier.mode;
	}

	public void setType(String type) {
		/**
		 * Change the field's type.
		 */
		this.type = type;
	}

	public String getType() {
		/**
		 * Get the field's type.
		 */
		return this.type;
	}
	
	public String getLabel() {
		/**
		 * Returns a copy of this field's label. This cannot be used for insitu alteration.
		 */
		return label;
	}

}
