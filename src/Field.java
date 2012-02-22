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

	public void set_am(int am) {
		/**
		 * Set this field's access modifier.
		 */
	}

	public AccessModifier get_am() {
		/**
		 * Fetch this field's access modifier.
		 */
		return new AccessModifier();
	}

	public void set_type(String type) {
		/**
		 * Change the field's type.
		 */
		this.type = type;
	}

	public String get_type() {
		/**
		 * Get the field's type.
		 */
		return this.type;
	}



}
