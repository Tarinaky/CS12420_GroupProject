import javax.swing.*;
import javax.swing.border.TitledBorder;
import model.Classes;
import model.Field;

import java.awt.FlowLayout;
import java.awt.event.*;
/*
 * Class for JPanels and JOptionPanes of some button Functionalities.
 * e.g. Add Method, Add Field
 */
public class JOFrame extends JPanel {
	
	
	public void joPanel(String title) {
		
		String[] aModifiers = {"Public", "Private"};
		JPanel panel = new JPanel(); //creates panel
		JTextField typeField = new JTextField(5); //type text field
		JTextField nameField = new JTextField(5); //name text field
		JComboBox list = new JComboBox(aModifiers); //drop-down menu for access Modifier
		
		panel.add(new JLabel("Access Modifier: "));
		panel.add(list);
		
		panel.add(new JLabel("Type: "));
		panel.add(typeField);
		
		panel.add(new JLabel("Name: "));
		panel.add(nameField);
		
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			/* Output of the Combobox and textFields.
			 * You can obtain their values with .getText();
			 * TextField values are String,
			 * list values are int...I think.
			 */
			System.out.println("Access Modifier: " + list.getSelectedIndex());
			System.out.println("Type value: " + typeField.getText());
			System.out.println("Name value: " + nameField.getText());
		}
		
	}
	
	public void joFieldtoMethod(String title, String[] methodList) {
		
		JPanel panel = new JPanel(); //creates panel
		JComboBox methodlist = new JComboBox(methodList); //drop-down menu of methods
		String[] aModifiers = {"Public", "Private"};
		JComboBox list = new JComboBox(aModifiers); //drop-down menu for access modifiers
		JTextField typeField = new JTextField(5); //type text field
		JTextField nameField = new JTextField(5); //name text field
		

		panel.add(new JLabel("Method "));
		panel.add(methodlist);
		
		panel.add(new JLabel("Access Modifier: "));
		panel.add(list);
		
		panel.add(new JLabel("Type: "));
		panel.add(typeField);
		
		panel.add(new JLabel("Name: "));
		panel.add(nameField);
		
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			/* Output of the Combobox and textFields.
			 * You can obtain their values with .getText();
			 * TextField values are String,
			 * list values are int...I think.
			 */
			System.out.println("Method: " + methodlist.getSelectedIndex());
			System.out.println("Access Modifier: " + list.getSelectedIndex());
			System.out.println("Type value: " + typeField.getText());
			System.out.println("Name value: " + nameField.getText());
		}
		
	}
	
	public void joCardinality(String title) {
		
		JPanel panel = new JPanel();
		/*
		 * 
		 * panel contents of the JOptionPane.
		 * 
		 */
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) {
			/*
			 * 
			 * use .getText(); method to retrieve values from panel contents.
			 * e.g. textfield.getText();
			 * 
			 */
		}
	}
	
	public void joList(String title, String[] fieldList) {
		
		JComboBox list = new JComboBox(fieldList); //drop-down menu of fields
		
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(null, list, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) {
			/*
			 * 
			 * use .getText(); method to retrieve values from panel contents.
			 * e.g. textfield.getText();
			 * 
			 */
		
		}
	
	}
	
}
