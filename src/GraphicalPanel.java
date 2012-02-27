import javax.swing.*;
import java.awt.*;
import java.util.*;

import model.*;

public class GraphicalPanel extends JLayeredPane{
	
	private Design design = new Design();
	private Collection<Classes> classes = design.getAllClasses();

	
	GraphicalPanel()
	{
		design.addClass(new Classes("Tstings")).setPosition(new Point(400,100));
		design.addClass(new Classes("Better"));
		this.setSize(900, 600);
		this.setPreferredSize(new Dimension(900, 600));
		this.setBackground(Color.green);
		this.setOpaque(true);
		drawClasses();
	}
	
	public void drawGraphicalPane()
	{
		drawClasses();
	}
	
	public void drawClasses()
	{
	   	for(Classes theClass: classes)
	   	{
			JLabel drawnClass = drawClass(theClass);
			this.add(drawnClass, 3);	
	   	}
	}
	
	private String getClassesMethodsHTML(Classes theClass)
	{
		return "";
	}
	
    private JLabel drawClass(Classes theClass) {
    	String labelHtml = "<html><div style=\"text-align: center; width:102px;\">+"
    						+ theClass.getLabel() + "</div>";
		JLabel label = new JLabel(labelHtml + "</html>");
		label.setVerticalAlignment(JLabel.TOP);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setBounds(theClass.getPosition().x, theClass.getPosition().y, 140, 140);
		return label;
    }
}
