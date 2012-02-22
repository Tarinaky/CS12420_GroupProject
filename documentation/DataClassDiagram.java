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

	public void rename(String label) {}
	
	public Link get_lnk(String label) {}
	public void add_lnk(Link link) {}
	public void rm_lnk(String label) {}

	public void set_comment(String comment) {}
	public String get_comment() {}

	public Field add_field(String label, Field field) {}
	public void get_field(String label) {}
	public void rm_field(String label) {}
}

/**
 * @opt all
 * @assoc 1 - 1 AccessModifier
 */
class Field {
	private String label;

	private String type;
	
	private AccessModifier accessModifier;

	public Field() {}
	
	public void set_label(String label) {}
	public void set_am(AccessModifier am) {}
	public AccessModifier get_am() {}

	public void set_type(String type) {}
	public String get_type() {}

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

	public Link(String label,Classes classA, Classes classB) {}

	public void set_label(String label) {}

	public void set_cardinality(int A, int B) {}
	public int get_cardinalityA() {}
	public int get_cardinalityB() {}

	public void set_classA(Classes classA) {}
	public void set_classB(Classes classB) {}
}

/**
 * @opt all
 * @assoc 1 - * Classes
 */
class Design {
	private Map<String,Classes> classes;

	public void add_class(Classes classes) {}
	public void rm_class(String label) {}
	public Classes get_class(String label) {}
}

/**
 * @opt all
 */
class Method extends Field {
	private List<Field> parameters;
	
	public void set_parameters(List<Field> parameters) {}
	public List<Field> get_parameters() {}

	public Method() {}
}

