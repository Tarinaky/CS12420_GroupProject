package model;
import java.util.*;

import apple.laf.JRSUIUtils.Tree;

public class Method extends Field implements java.io.Serializable {
	/**
	 * This class is the special case of a field that is a method.
	 * Method's return type is stored as the type of field (since it expands to the same type during execution). This leaves the parameters/arguments list as the only real difference.
	 */
	private Map<String, Field> parameters;

	public Method(String label) {
		/**
		 * Ctor
		 */
		super(label);
		parameters = new TreeMap<String,Field>();
	}

	public Collection<Field> getParameters() {
		/**
		 * Return a handle to the parameters list. This does not return a copy but instead returns the actual object. Alterations can be performed 'in place' by adding or removing from the handle returned by this method.
		 */
		return parameters.values();
	}
	
	public Field getParameter(String label) {
		/**
		 * Retrieve a field by its label. Returns null if no such field exists.
		 */
		return parameters.get(label);
	}
	
	public void addParameter(Field parameter)
	{
		/**
		 * Add a single parameter to this method's current parameter list.
		 */
		parameters.put(parameter.getLabel(), parameter);
	}

}

