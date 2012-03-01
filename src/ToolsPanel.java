import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class ToolsPanel extends JPanel{
	ToolsPanel()
	{
		
		this.setSize(900, 200);
		this.setPreferredSize(new Dimension(900, 38));
		this.setBackground(Color.gray);
		loadNonSelectedButtons();
	}
	
	public void loadNonSelectedButtons()
	{
		this.add(new JButton("Add Class"));
		this.add(new JButton("Remove Class"));
	}
}
