import java.awt.BorderLayout;

import javax.swing.*;

public class MenuBar {
	
	public MenuBar() {
		
		//MenuBar
		JMenuBar menuBar = new JMenuBar();
		//File Menu
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		//Help Menu
		JMenu helpMenu = new JMenu("Help");
		JMenuItem aboutItem = new JMenuItem("About");
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		fileMenu.add(exitItem);
		
		MenuActionListener listener = new MenuActionListener();
		exitItem.addActionListener(listener);
		
	}
	
}
