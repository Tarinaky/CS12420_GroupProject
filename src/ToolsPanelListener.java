import java.awt.event.*;

import javax.swing.JOptionPane;

import model.Design;

public class ToolsPanelListener implements ActionListener {
	
	public ToolsPanelListener(Design design, GraphicalPanel graphicalPanel) {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		
		String taction = e.getActionCommand();
		
		if(taction.equals("Add Method")){
			JOptionPane.showMessageDialog(null, "Add Method");
			AddMethodFrame amF = new AddMethodFrame();
			
		}
		
	}
	
}
