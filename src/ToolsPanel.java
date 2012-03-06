import javax.swing.*;
import model.*;
import javax.swing.border.Border;
import java.awt.*;

public class ToolsPanel extends JPanel{
	private GraphicalPanel graphicalPanel;
	private Design design;
	private ClassActionListener toolsListener;

	ToolsPanel(Design design, GraphicalPanel graphicalPanel)
	{
		this.design = design;
		this.graphicalPanel = graphicalPanel;
		this.setPreferredSize(new Dimension(900, 80));
		this.setBackground(Color.gray);
		toolsListener = new ClassActionListener(design, graphicalPanel);
		loadNonSelectedButtons();
	}
	
	public void loadNonSelectedButtons()
	{
		JButton addClassButton = new JButton("Add Class");
		addClassButton.addActionListener(toolsListener);
		this.add(addClassButton);
		JButton removeClassButton = new JButton("Remove Class");
		removeClassButton.addActionListener(toolsListener);
		this.add(removeClassButton);
		this.validate();
	}
	
	public void loadClassSelectedButtons()
	{
		//Add Field Button
		JButton addVariableButton = new JButton("Add Field");
		addVariableButton.addActionListener(toolsListener);
		this.add(addVariableButton);
		
		//Add Method Button
		JButton addMethodButton = new JButton("Add Method");
		addMethodButton.addActionListener(toolsListener);
		this.add(addMethodButton);
		
		//Add Field to Method button
		JButton addFieldToMethodButton = new JButton("Add Field to Method");
		addFieldToMethodButton.addActionListener(toolsListener);
		this.add(addFieldToMethodButton);
		
		//Add Cardinality
		JButton addCardinalityButton = new JButton("Add Cardinality");
		addCardinalityButton.addActionListener(toolsListener);
		this.add(addCardinalityButton);
		
		//Remove Field Button
		JButton removeVariableButton = new JButton("Remove Field");
		removeVariableButton.addActionListener(toolsListener);
		this.add(removeVariableButton);
		
		//Add Method Button
		JButton removeMethodButton = new JButton("Remove Method");
		removeMethodButton.addActionListener(toolsListener);
		this.add(removeMethodButton);
		
		//Add Field to Method button
		JButton removeFieldFromMethodButton = new JButton("Remove Field from Method");
		removeFieldFromMethodButton.addActionListener(toolsListener);
		this.add(removeFieldFromMethodButton);
		
		//Add Cardinality
		JButton removeCardinalityButton = new JButton("Remove Cardinality");
		removeCardinalityButton.addActionListener(toolsListener);
		this.add(removeCardinalityButton);
		
		this.validate();
	}
}
