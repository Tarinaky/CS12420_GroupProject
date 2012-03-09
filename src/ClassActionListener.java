import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

import model.*;

public class ClassActionListener implements ActionListener {
	private Design design;
	private GraphicalPanel graphicalPanel;
	
	ClassActionListener(Design design, GraphicalPanel graphicalPanel)
	{
		this.design = design;
		this.graphicalPanel = graphicalPanel;
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		String actionCommand = evt.getActionCommand();

		if(actionCommand.equals("Add Class")) {
			String response = JOptionPane.showInputDialog(null,
					  "What is the name of your class?",
					  "Please enter a name for the class",
					  JOptionPane.PLAIN_MESSAGE);
			
			if(response!=null&&(!response.isEmpty())&&design.getClass(response)==null)
				design.addClass(new Classes(response));
			else
				JOptionPane.showMessageDialog(null, "You have entered an invalid class name.", "Error", JOptionPane.ERROR_MESSAGE);
			graphicalPanel.repaint();
		}
		else if(actionCommand.equals("Remove Class")) {
			String[] classes = new String[design.getAllClasses().size()];
			int count = 0;
			for(Classes theClass: design.getAllClasses())
			{
				classes[count] = theClass.getLabel();
				count++;
			}
			String response = (String) JOptionPane.showInputDialog(null, "Which class would you like to remove?",
			        "Please choose a class to remove", JOptionPane.PLAIN_MESSAGE, null, 
			        classes,
			        classes[0]);
			if(response!=null)
				design.removeClass(response);
			graphicalPanel.repaint();
			
		}
		/*/////////////////////////////////////////////////////////
		 * The code below uses the classes from JOFrame.java.
		 * 
		 * The method "joPanel" creates a JOptionPane for
		 * the buttons "Add Method" and "Add Field".
		 * 
		 * The method "joList" creates a JOptionPane for
		 * the buttons "Remove Method" and "Remove Field".
		 *////////////////////////////////////////////////////////
		
		else if(actionCommand.equals("Add Method")) {
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joPanel("Method");
			
			System.out.println(actionCommand);
			
		}else if(actionCommand.equals("Remove Method")) {
			ArrayList<String> methodList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(theField instanceof Method)
				{
					methodList.add(theField.getLabel());
				}
			}
			String[] listOfMethods = Arrays.copyOf(methodList.toArray(), methodList.toArray().length, String[].class);
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			Object removeItem = joframe.joList("Remove Method",  listOfMethods);
			if(removeItem!=null)
			{
				graphicalPanel.getMouseSelectedClass().removeField(removeItem.toString());
				graphicalPanel.repaint();
			}
						
		}else if(actionCommand.equals("Add Field")) {
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joPanel("Field");
			
			System.out.println(actionCommand);
			
		}else if(actionCommand.equals("Remove Field")) {
			ArrayList<String> fieldList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(!(theField instanceof Method))
				{
					fieldList.add(theField.getLabel());
				}
			}
			String[] fields = Arrays.copyOf(fieldList.toArray(), fieldList.toArray().length, String[].class);
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			Object removeItem = joframe.joList("Remove Field", fields);
			if(removeItem!=null)
			{
				graphicalPanel.getMouseSelectedClass().removeField(removeItem.toString());
				graphicalPanel.repaint();
			}
			
		}else if(actionCommand.equals("Add Field-to-Method")) {
			String[] methods = new String[2];
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joFieldtoMethod("Add Field-to-Method");		
			
		}else if(actionCommand.equals("Add Cardinality")) {
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joCardinality("Add Cardinality");
			
		}else if(actionCommand.equals("Remove Field-from-Method")) {
			ArrayList<String> methodList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(theField instanceof Method)
				{
					methodList.add(theField.getLabel());
				}
			}
			String[] listOfMethods = Arrays.copyOf(methodList.toArray(), methodList.toArray().length, String[].class);
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			Object selectedMethod = joframe.joList("Method of field to remove",  listOfMethods);
			if(selectedMethod!=null)
			{
				Method methodsFields = (Method) graphicalPanel.getMouseSelectedClass().getField(selectedMethod.toString());
				ArrayList<String> fieldList = new ArrayList<String>();
				for(Field theField: methodsFields.getParameters())
				{
					fieldList.add(theField.getLabel());
				}
				String[] fields = Arrays.copyOf(fieldList.toArray(), fieldList.toArray().length, String[].class);
				JOFrame joframeSecound = new JOFrame(this.design, this.graphicalPanel);
				Object removeItem = joframeSecound.joList("Field to remove", fields);
				if(removeItem!=null)
				{
					methodsFields.removeParameter(removeItem.toString());
					graphicalPanel.repaint();
				}
				graphicalPanel.repaint();
			}
			
		}else if(actionCommand.equals("Edit Class Name")){
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joEditName(graphicalPanel.getMouseSelectedClass().getLabel(),"Name: ", "Edit Name");
			
		}else if(actionCommand.equals("Edit Field")){
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			ArrayList<String> fieldList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(!(theField instanceof Method))
				{
					fieldList.add(theField.getLabel());
				}
			}
			String[] fields = Arrays.copyOf(fieldList.toArray(), fieldList.toArray().length, String[].class);
			Object selectedField = joframe.joList("Select field to edit!",  fields);
			JOFrame joframeSecond = new JOFrame(this.design, this.graphicalPanel);
			joframe.joEditFM("Field", graphicalPanel.getMouseSelectedClass().getField(selectedField.toString()));
			
		}else if(actionCommand.equals("Edit Method")){
			ArrayList<String> methodList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(theField instanceof Method)
				{
					methodList.add(theField.getLabel());
				}
			}
			String[] listOfMethods = Arrays.copyOf(methodList.toArray(), methodList.toArray().length, String[].class);
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			Object selectedMethod = joframe.joList("Select method to edit!",  listOfMethods);
			JOFrame joframeSecond = new JOFrame(this.design, this.graphicalPanel);
			joframe.joEditFM("Method", graphicalPanel.getMouseSelectedClass().getField(selectedMethod.toString()));
			
		}else if(actionCommand.equals("Edit Fields-in-Method")) {
			ArrayList<String> methodList = new ArrayList<String>();
			for(Field theField: graphicalPanel.getMouseSelectedClass().getFields())
			{
				if(theField instanceof Method)
				{
					methodList.add(theField.getLabel());
				}
			}
			String[] listOfMethods = Arrays.copyOf(methodList.toArray(), methodList.toArray().length, String[].class);
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			Object selectedMethod = joframe.joList("Method of field to edit",  listOfMethods);
			if(selectedMethod!=null)
			{
				Method methodsFields = (Method) graphicalPanel.getMouseSelectedClass().getField(selectedMethod.toString());
				ArrayList<String> fieldList = new ArrayList<String>();
				for(Field theField: methodsFields.getParameters())
				{
					fieldList.add(theField.getLabel());
				}
				String[] fields = Arrays.copyOf(fieldList.toArray(), fieldList.toArray().length, String[].class);
				JOFrame joframeSecound = new JOFrame(this.design, this.graphicalPanel);
				Object editItem = joframeSecound.joList("Field to edit", fields);
				if(editItem!=null)
				{
					joframeSecound.joEditFieldToMethod("Edit Field-in-Method", methodsFields.getParameter(editItem.toString()), methodsFields);
					graphicalPanel.repaint();
				}
				graphicalPanel.repaint();
			}
			
		}else if(actionCommand.equals("Edit Cardinality")){
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joEditName("getCardinality", "Cardinality: ", actionCommand);
			
		}else {
			System.out.println("ERROR: Unexpected ActionCommand!");
		}
	}

}

