import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class GraphicalPanel extends JPanel{
	GraphicalPanel()
	{
		Border loweredboarder = BorderFactory.createLoweredBevelBorder();
		
		this.setBorder(loweredboarder);
		this.setSize(900, 600);
		this.setPreferredSize(new Dimension(900, 600));
		this.setBackground(Color.lightGray);
	}
}
