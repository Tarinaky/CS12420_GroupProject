import javax.swing.*;

import model.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		GraphicalPanel graphicalPanel = new GraphicalPanel();
		this.add(graphicalPanel, BorderLayout.CENTER);
		ToolsPanel toolsPanel = new ToolsPanel(graphicalPanel.getDesign(), graphicalPanel);
		this.add(toolsPanel, BorderLayout.SOUTH);
		GraphicalMouseMotionListener mouseListener = new GraphicalMouseMotionListener(graphicalPanel, toolsPanel);
		graphicalPanel.addMouseListener(mouseListener);
		graphicalPanel.addMouseMotionListener(mouseListener);
		MenuBar menuBar = new MenuBar();
		menuBar.graphicalPanel(graphicalPanel);
		this.add(menuBar, BorderLayout.NORTH);

		this.setTitle("Class Builder - CS124 Group Project");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(60, 60);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}

	
}
