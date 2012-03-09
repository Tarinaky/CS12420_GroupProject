import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import model.*;

import javax.swing.*;

import sun.tools.java.ClassNotFound;
/*
 * ActionListeners were added inside the MenuBar.java file
 * because of difficulties in dealing with the 
 * JFileChooser object.
 */
public class MenuBar extends JMenuBar {
	
	private GraphicalPanel gp;
	private JFileChooser fc = new JFileChooser();
	private JFileChooser fco = new JFileChooser();
	private JFileChooser fcs = new JFileChooser();

	public MenuBar(GraphicalPanel graphicp) {
		
		this.gp = graphicp;
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fco.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
		fcs.setFileSelectionMode(JFileChooser.SAVE_DIALOG);

		//File Menu
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_Q);
		JMenuItem exportItem = new JMenuItem("Export to Code");

		//Help Menu
		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		
		this.add(fileMenu);
		this.add(helpMenu);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
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
		openItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logistics("Open",fco,gp);
			}
			
		});
		saveItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				logistics("Save",fcs,gp);
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
				try{
				gp.getDesign().exportToFolder(file);
				}catch(IOException ex){
				}
				//Replace code below ("System.out...") for file export methods.
				//System.out.println(file.getName() + " stored");
			}else{
				System.out.println("Save/ChooseFile cancelled by user");
			}
			
		}
		if(mAction.equals("Open")){
			/*
			 * Opens a FileChooser Dialog box allowing the user
			 * to browse through directories and save their 
			 * file.
			 */
			
			int returnVal = fco.showSaveDialog(MenuBar.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				
				File file = fco.getSelectedFile();
				try{
					Design newDesign = gp.getDesign();
					newDesign = Design.loadFrom(file.getAbsolutePath().toString());
					gp.repaint();
				}catch(IOException ex){
				}catch(ClassNotFoundException ex){
				}
				//Replace code below ("System.out...") for file export methods.
				//System.out.println(file.getName() + " stored");
			}else{
				System.out.println("Save/ChooseFile cancelled by user");
			}
			
		}
		if(mAction.equals("Save")){
			/*
			 * Opens a FileChooser Dialog box allowing the user
			 * to browse through directories and save their 
			 * file.
			 */
			
			int returnVal = fcs.showSaveDialog(MenuBar.this);
			if(returnVal == JFileChooser.APPROVE_OPTION){
				
				File file = fcs.getSelectedFile();
				try{
				gp.getDesign().saveTo(file.getAbsolutePath().toString());
				}catch(IOException ex){
				}
				//Replace code below ("System.out...") for file export methods.
				//System.out.println(file.getName() + " stored");
			}else{
				System.out.println("Save/ChooseFile cancelled by user");
			}
			
		}
		if(mAction.equals("About")){
			JOptionPane.showMessageDialog(gp, "CS124 Group Project",mAction, JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
}
