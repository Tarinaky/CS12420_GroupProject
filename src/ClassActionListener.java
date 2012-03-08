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
					  JOptionPane.QUESTION_MESSAGE);
			design.addClass(new Classes(response));
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
			        "Please choose a class to remove", JOptionPane.QUESTION_MESSAGE, null, 
			        classes,
			        classes[0]);
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
			joframe.joList("Remove Method",  listOfMethods);
						
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
			joframe.joList("Remove Field", fields);
			
			System.out.println(actionCommand);
			
		}else if(actionCommand.equals("Add Field-to-Method")) {
			String[] methods = new String[2];
			JOFrame joframe = new JOFrame(this.design, this.graphicalPanel);
			joframe.joFieldtoMethod("Add Field-to-Method");			
		}else if(actionCommand.equals("Add Cardinality")) {
			
			
			
		}else {
			System.out.println("ERROR: Unexpected ActionCommand!");
		}
	}

}

