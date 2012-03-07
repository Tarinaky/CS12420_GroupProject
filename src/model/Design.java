package model;
import java.util.*;
import java.awt.Component;
import java.io.*;

public class Design implements java.io.Serializable {
	/**
	 * Design is a class describing all of the backend data for a class diagram.
	 */
	private Map<String,Classes> classes;

	public Design() {//Ctor
		classes = new TreeMap<String,Classes>();

	}

	public Classes addClass(Classes add) {
		/**
		 * Add a class to the database.
		 */
		add.setLayer(classes.size());
		String key = add.getLabel();
		classes.put(key, add);
		return add;
	}

	public void removeClass(String label) {
		/**
		 * Remove a class from the database by its label.
		 */
		classes.remove(label);
	}

	public Classes getClass(String label) {
		/**
		 * Return the class associated with a given label.
		 */
		return classes.get(label);
	}
	
	public Collection<Classes> getAllClasses()
	{
		/**
		 * Return tree map of all classes.
		 */
		return classes.values();
	}
	
	public void saveTo(String filename) throws IOException {
		/**
		 * Serialize the Design to a file.
		 */
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename) );
		outputStream.writeObject(this);
		outputStream.close();		
	}
	
	public static Design loadFrom(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename) );
		Design loaded = (Design)inputStream.readObject();
		return loaded;
	}

	public void exportToFolder(File folder) throws IOException {
		for (Classes classes : getAllClasses() ) {
			classes.exportToFile(new File(folder,classes.getLabel()+".java") );
		}
	}
	
}

