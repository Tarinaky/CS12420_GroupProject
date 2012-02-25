/**
 * @hidden
 */
class Map<K,V> {}

/**
 * @hidden
 */
class List<T> {}

/**
 * @opt all
 * @assoc 1 - * Field
 * @assoc * - * Link
*/
class Classes {
	private String label;
	private Map<String,Link> links;
	private String comment;
	private Map<String,Field> fields;

	public Classes(String label) {}

	public void rename(String label, Design design) {}
	
	public Link getLink(String label) {}
	public void addLink(Link link) {}
	public void removeLink(String label) {}

	public void setComment(String comment) {}
	public String getComment() {}

	public Field addField(String label, Field field) {}
	public void getField(String label) {}
	public void rmField(String label) {}
}

/**
 * @opt all
 * @assoc 1 - 1 AccessModifier
 */
class Field {
	private String label;

	private String type;
	
	private AccessModifier accessModifier;

	public Field(String label) {}
	
	public void rename(String label,Classes classes) {}
	public void setAccessModifier(AccessModifier am) {}
	public AccessModifier getAccessModifier() {}

	public void setType(String type) {}
	public String getType() {}

}

/**
 * @opt all
 */
class AccessModifier {
	public int PUBLIC = 0;
	public int PROTECTED = 1;
	public int PRIVATE = -1;
	public int mode;

	public AccessModifier(int i) {}
}

/**
 * @opt all
 */
class Link {
	private String label;
	
	private int cardinalityA, cardinalityB;
	public static int CARDINALITY_ONE = 1;
	public static int CARDINALITY_MANY = -1;
	public static int INHERITANCE = 0;

	private Classes classA, classB;

	public Link(String label) {}

	public void rename(String label) {}

	public void setCardinality(int A, int B) {}
	public int getCardinalityA() {}
	public int getCardinalityB() {}

	public void setClassA(Classes classA) {}
	public void setClassB(Classes classB) {}
}

/**
 * @opt all
 * @assoc 1 - * Classes
 */
class Design {
	private Map<String,Classes> classes;

	public void addClass(Classes classes) {}
	public void removeClass(String label) {}
	public Classes getClass(String label) {}
}

/**
 * @opt all
 */
class Method extends Field {
	private List<Field> parameters;
	
	public void setParameters(List<Field> parameters) {}
	public List<Field> getParameters() {}

	public Method() {}
}

