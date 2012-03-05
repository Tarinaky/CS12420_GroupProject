import javax.swing.*;
import java.awt.*;
import java.util.*;

import javax.swing.border.Border;

import model.*;

public class GraphicalPanel extends JLayeredPane{
	
	private Design design = new Design();
	private Collection<Classes> classes = design.getAllClasses();

	
	GraphicalPanel()
	{

		this.setSize(900, 600);
		this.setPreferredSize(new Dimension(900, 600));
		this.setBackground(Color.green);
		this.setOpaque(true);
		this.setLayout(null);
		addTestItems();
		drawClasses();
	}
	
	private void addTestItems()
	{
		Classes testingClass = design.addClass(new Classes("Testing"));
		testingClass.setPosition(new Point(400,100)); //Move it to a different posiiton
		Method newMethod = new Method("addUser");
		newMethod.setType("void");
		newMethod.setAccessModifier(AccessModifier.PUBLIC);
		testingClass.addField(newMethod);
		
		
		Classes betterClass = design.addClass(new Classes("Better"));
		Method betterMethod = new Method("addUser");
		betterMethod.setType("void");
		betterMethod.setAccessModifier(AccessModifier.PRIVATE);
		betterClass.addField(betterMethod);
		betterClass.addField(new Field("username"), "String", AccessModifier.PUBLIC);
		
	}
	
	public void drawGraphicalPane()
	{
		drawClasses();
	}
	
	public String getSymbolFromAccessModifier(int accessModifer)
	{
		switch (accessModifer)
		{
			case 0:
				return "+";
			case 1:
				return "#";
			case 2:
				return "-";	
			default:
				return "";
		}
		
	}
	
	public void drawClasses()
	{
		int numObjects = 0;
	   	for(Classes theClass: classes)
	   	{
			JLabel drawnClass = drawClass(theClass);
			this.add(drawnClass, numObjects);
			numObjects++;
	   	}
	}
	
	private String getClassesFeildsHTML(Classes theClass)
	{
		String returnMethods = "";
		String returnParameters = "";
		for(Field field: theClass.getFields())
		{
			if(field instanceof Method)
			{
				returnMethods += "<p style=\"padding: 0 10px;\">" + getSymbolFromAccessModifier(field.getAccessModifier()) 
						+ " " + field.getLabel() + "(): " + field.getType() + "</p>";
			}
			else
			{
				returnParameters += "<p style=\"padding: 0 10px;\">" + getSymbolFromAccessModifier(field.getAccessModifier())
						+ " " + field.getLabel() + " : " + field.getType() + "</p>";
			}
		}
		return returnParameters + "<hr>" + returnMethods;
	}
	
    private JLabel drawClass(Classes theClass) {
    	String labelHtml = "<html><div style=\"text-align: center; padding: 0 35px; width:100%; display: inline;\">"
    						+ theClass.getLabel() + "</div><hr width=\"100%\">";
    	labelHtml += getClassesFeildsHTML(theClass);
		JLabel label = new JLabel(labelHtml + "<p></html>");
		
		label.setVerticalAlignment(JLabel.TOP);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setForeground(Color.black);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		label.setLocation(theClass.getPosition().x, theClass.getPosition().y);
		label.setBounds(new Rectangle(theClass.getPosition(), new Dimension(label.getPreferredSize().width, label.getPreferredSize().height+5)));
		return label;
    }
}
