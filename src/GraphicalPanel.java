import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Map;

import model.*;

public class GraphicalPanel extends JLayeredPane{
	
	private Design design = new Design();
	private Map<String,Classes> classes = design.getAllClasses();

	
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
		//obtain Iterator for all classes
	    Iterator<Classes> itr = classes.values().iterator();
	   	while(itr.hasNext())
	   	{
			JLabel drawnClass = drawClass(itr.next());
			this.add(drawnClass, 3);	
	   	}
	}
	
    private JLabel drawClass(Classes theClass) {
		JLabel label = new JLabel("<html><div style=\"text-align: center; width:102px;\">+" + theClass.getLabel() + "</div><p>Testing<p>lol</html>");
		label.setVerticalAlignment(JLabel.TOP);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setBounds(theClass.getPosition().x, theClass.getPosition().y, 140, 140);
		return label;
    }
}
