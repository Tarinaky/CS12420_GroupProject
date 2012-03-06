import java.awt.event.*;
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
		}else {
			System.out.println("ERROR: Unexpected ActionCommand!");
		}
	}

}

