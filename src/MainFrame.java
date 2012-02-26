import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
	public MainFrame() {
	
		GraphicalPanel graphicalPanel = new GraphicalPanel();
		this.add(graphicalPanel, BorderLayout.NORTH);
		
		ToolsPanel toolsPanel = new ToolsPanel();
		this.add(toolsPanel, BorderLayout.CENTER);

		this.setTitle("Class Builder - CS124 Group Project");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(60, 60);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
