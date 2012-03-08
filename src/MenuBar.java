import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.*;
/*
 * ActionListeners were added inside the MenuBar.java file
 * because of difficulties in dealing with the 
 * JFileChooser object.
 */
public class MenuBar extends JMenuBar {
	
	private GraphicalPanel gp;
	
	public void graphicalPanel(GraphicalPanel graphicp){
		this.gp = graphicp;
	}
	
	public MenuBar() {
		
		final JFileChooser fc = new JFileChooser();
		
		//File Menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_Q);
		JMenuItem exportItem = new JMenuItem("Export to Code");
		//Help Menu
		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		
		this.add(fileMenu);
		this.add(helpMenu);
		
		fileMenu.add(exportItem);
		fileMenu.add(exitItem);
		
		helpMenu.add(aboutItem);
		
		MenuActionListener listener = new MenuActionListener();
		exitItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logistics("Exit",fc,gp);
			}
			
		});
		exportItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logistics("Export to Code",fc,gp);
			}
			
		});
		aboutItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logistics("About",fc,gp);
			}
			
		});
		
	}
	
	public void logistics(String mAction, JFileChooser fc, GraphicalPanel gp) {
		
		if(mAction.equals("Exit")){
			System.exit(0);
		}
		if(mAction.equals("Export to Code")){
			/*
			 * Opens a FileChooser Dialog box allowing the user
			 * to browse through directories and save their 
			 * file.
			 */
			
			int returnVal = fc.showSaveDialog(MenuBar.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				File file = fc.getSelectedFile();
				//Replace code below ("System.out...") for file export methods.
				System.out.println(file.getName() + " stored");
			}else{
				System.out.println("Save cancelled by user");
			}
			
		}
		if(mAction.equals("About")){
			JOptionPane.showMessageDialog(gp, "CS124 Group Project",mAction, JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
}
