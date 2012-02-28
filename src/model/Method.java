package model;
import java.util.*;

public class Method extends Field implements java.io.Serializable {
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

	public List<Field> getParameters() {
		/**
		 * Return a handle to the parameters list. This does not return a copy but instead returns the actual object. Alterations can be performed 'in place' by adding or removing from the handle returned by this method.
		 */
		return parameters;
	}
	
	public void addParameter(Field parameter)
	{
		parameters.add(parameter);
	}

}
