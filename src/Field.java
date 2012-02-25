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
	}

	public void setAccessModifier(int am) {
		/**
		 * Set this field's access modifier.
		 */
	}

	public AccessModifier getAccessModifier() {
		/**
		 * Fetch this field's access modifier.
		 */
		return new AccessModifier();
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
		return new String(label);
	}

}
