package model;
public class AccessModifier implements java.io.Serializable {
	/**
	 * Class representing standard java access modifiers.
	 */

	public static int PUBLIC = 0;
	public static int PROTECTED = 1;
	public static int PRIVATE = 2;

	public int mode;

	public AccessModifier() {
		mode = PUBLIC;
	}

	public AccessModifier(int mode) {
		this.mode = mode;
	}

}

