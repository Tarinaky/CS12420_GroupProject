import java.util.*;

public class Method extends Field {
	/**
	 * This class is the special case of a field that is a method.
	 * Method's return type is stored as the type of field (since it expands to the same type during execution). This leaves the parameters/arguments list as the only real difference.
	 */
	private List<Field> parameters;

	public Method(String label) {
		/**
		 * Ctor
		 */
		super(label);
		parameters = new LinkedList<Field>();
	}

	public void setParameters(List<Field> list) {
		/**
		 * Write a new parameters list to this Method, overwriting the existing one. Note: This does not add parameters but replace the pointer with one to a different object.
		 */
		this.parameters = list;
	}

	public List<Field> getParameters() {
		/**
		 * Return a handle to the parameters list. This does not return a copy but instead returns the actual object. Alterations can be performed 'in place' by adding or removing from the handle returned by this method.
		 */
		return parameters;
	}

}
