import javax.swing.*;

import model.*;
import java.util.ArrayList;
/*
 * Class for JPanels and JOptionPanes of some button Functionalities.
 * e.g. Add Method, Add Field
 */
public class JOFrame extends JPanel {
	
	private Design design;
	private GraphicalPanel graphicalPanel;
	
	JOFrame(Design design, GraphicalPanel graphicalPanel)
	{
		this.graphicalPanel = graphicalPanel;
		this.design = design;
	}
	
	public void joPanel(String title) {
		
		String[] aModifiers = {"Public", "Protected", "Private"};
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
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, "Add " + title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			/* Output of the Combobox and textFields.
			 * You can obtain their values with .getText();
			 * TextField values are String,
			 * list values are int...I think.
			 */
			if(graphicalPanel.getMouseSelectedClass().getField(nameField.getText())==null){
				if(title=="Method"){
					Method addMethod = new Method(nameField.getText());
					addMethod.setAccessModifier(list.getSelectedIndex());
					addMethod.setType(typeField.getText());
					graphicalPanel.getMouseSelectedClass().addField(addMethod);
				}else{
					Field addField = new Field(nameField.getText());
					addField.setAccessModifier(list.getSelectedIndex());
					addField.setType(typeField.getText());
					graphicalPanel.getMouseSelectedClass().addField(addField);
				}

				graphicalPanel.repaint();
			}
			else{
				JOptionPane.showMessageDialog(this, "You already have a " + title + " named " + nameField.getText()  , "Error", JOptionPane.ERROR_MESSAGE);
			}
				
		}
		
	}
	
	public void joFieldtoMethod(String title) {
		ArrayList<String> methodList = new ArrayList<String>();
		for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
		{
			if(theField instanceof Method)
			{
				methodList.add(theField.getLabel());
			}
		}
		if(!methodList.isEmpty())
		{
			JPanel panel = new JPanel(); //creates panel
			JComboBox methodlist = new JComboBox(methodList.toArray()); //drop-down menu of methods
			JTextField typeField = new JTextField(5); //type text field
			JTextField nameField = new JTextField(5); //name text field
			
	
			panel.add(new JLabel("Method "));
			panel.add(methodlist);
			
			
			panel.add(new JLabel("Type: "));
			panel.add(typeField);
			
			panel.add(new JLabel("Name: "));
			panel.add(nameField);
			
			//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
			int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(result == JOptionPane.OK_OPTION) {
				/* Output of the Combobox and textFields.
				 * You can obtain their values with .getText();
				 * TextField values are String,
				 * list values are int...I think.
				 */
				Method selectedMethod = (Method) graphicalPanel.getMouseSelectedClass().getField(methodlist.getSelectedItem().toString());
				if(selectedMethod.getParameter(nameField.getText())==null){
					Field fieldToAdd = new Field(nameField.getText());
					fieldToAdd.setType(typeField.getText());
					selectedMethod.addParameter(fieldToAdd);
					graphicalPanel.repaint();
				}else{
					JOptionPane.showMessageDialog(graphicalPanel, "You already have a parameter named " + nameField.getText() + " for " 
							+ methodlist.getSelectedItem().toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, "You don't have any methods in this class.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void joCardinality(String title) {
		//Classes selectedClass = 
		JPanel panel = new JPanel();
		/*
		 * 
		 * panel contents of the JOptionPane.
		 * 
		 */
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) {
			/*
			 * 
			 * use .getText(); method to retrieve values from panel contents.
			 * e.g. textfield.getText();
			 * 
			 */
		}
	}
	
	public void joList(String title, String nlabel, String[] fieldList) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel(nlabel);
		JComboBox list = new JComboBox(fieldList); //drop-down menu of fields
		
		panel.add(label);
		panel.add(list);
		
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) {
			/*
			 * 
			 * use .getText(); method to retrieve values from panel contents.
			 * e.g. textfield.getText();
			 * 
			 */
		
		}
	
	}
	
	public void joEditName(String name, String tlabel, String title) {
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(tlabel);
		JTextField tField = new JTextField(name, 8);
		panel.add(label);
		panel.add(tField);
		
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) 
		{
			if(design.getClass(tField.getText())==null&&tField.getText()!=null)
			{
				graphicalPanel.getMouseSelectedClass().rename(tField.getText(), design);
				graphicalPanel.repaint();
			}else{
				JOptionPane.showMessageDialog(this, "You have entered an invalid class name.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public Object joList(String title, String[] fieldList) {
		JComboBox list = new JComboBox(fieldList); //drop-down menu of fields
		
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(graphicalPanel, list, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(result == JOptionPane.OK_OPTION) 
			return list.getSelectedItem();
		else
			return null;
	
	}
	
	public void joEditFieldToMethod(String title, Field field, Method selectedMethod) {
		JPanel panel = new JPanel(); //creates panel
		JTextField typeField = new JTextField(field.getType()); //type text field
		JTextField nameField = new JTextField(field.getLabel()); //name text field

		panel.add(new JLabel("Type: "));
		panel.add(typeField);

		panel.add(new JLabel("Name: "));
		panel.add(nameField);

		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if(result == JOptionPane.OK_OPTION) {
			/* Output of the Combobox and textFields.
			 * You can obtain their values with .getText();
			 * TextField values are String,
			 * list values are int...I think.
			 */
			if((selectedMethod.getParameter(nameField.getText())==null)||nameField.getText().equals(field.getLabel())){
				field = selectedMethod.getParameter(field.getLabel());
				field.setType(typeField.getText());
				String oldLabel = field.getLabel();
				field.rename(nameField.getText());
				selectedMethod.renameParameter(oldLabel, field);
				
				graphicalPanel.repaint();
			}else{
				JOptionPane.showMessageDialog(graphicalPanel, "You already have a parameter named " + nameField.getText() + " for " 
						+ field.getLabel(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	//EDIT FIELD AND/OR METHOD
	public void joEditFM(String title, Field field){
		String[] aModifiers = {"Public", "Protected", "Private"};
		JPanel panel = new JPanel(); //creates panel
		JTextField typeField = new JTextField(field.getType()); //type text field
		JTextField nameField = new JTextField(field.getLabel()); //name text field
		JComboBox list = new JComboBox(aModifiers); //drop-down menu for access Modifier
		list.setSelectedIndex(field.getAccessModifier());
		panel.add(new JLabel("Access Modifier: "));
		panel.add(list);
		
		panel.add(new JLabel("Type: "));
		panel.add(typeField);
		
		panel.add(new JLabel("Name: "));
		panel.add(nameField);
				
		//!!!!!!!!!!although result is int, textfield values are returned as String!!!!!!!!!!!!
		int result = JOptionPane.showConfirmDialog(graphicalPanel, panel, "Add " + title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if(result == JOptionPane.OK_OPTION) {
			/* Output of the Combobox and textFields.
			 * You can obtain their values with .getText();
			 * TextField values are String,
			 * list values are int...I think.
			 */
			System.out.println(nameField.getText());
			if((graphicalPanel.getMouseSelectedClass().getField(nameField.getText())==null)||(nameField.getText().equals(field.getLabel()))){
				if(title=="Method"){
					Method editMethod = (Method) field;
					editMethod.setAccessModifier(list.getSelectedIndex());
					editMethod.setType(typeField.getText());
					editMethod.rename(nameField.getText(), graphicalPanel.getMouseSelectedClass());
				}else{
					Field editField = field;
					editField.setAccessModifier(list.getSelectedIndex());
					editField.setType(typeField.getText());
					editField.rename(nameField.getText(), graphicalPanel.getMouseSelectedClass());
				}

				graphicalPanel.repaint();
			}
			else{
				JOptionPane.showMessageDialog(this, "You already have a " + title + " named " + nameField.getText()  , "Error", JOptionPane.ERROR_MESSAGE);
			}
				
		}
	}
	
}
