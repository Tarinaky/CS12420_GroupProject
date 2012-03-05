import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MenuActionListener implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		
		String mAction = e.getActionCommand();
		
		if(mAction.equals("Exit")){
			System.exit(0);
		}
		if(mAction.equals("Export to Code")){
			JOptionPane.showMessageDialog(null, "Export Code");
		}
		if(mAction.equals("About")){
			JOptionPane.showMessageDialog(null, "CS124 Group Project! =D");
		}
		
	}
	
}


