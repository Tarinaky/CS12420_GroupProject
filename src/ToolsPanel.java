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
		this.setSize(900, 200);
		this.setPreferredSize(new Dimension(900, 38));
		this.setBackground(Color.ORANGE);
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
		JButton addClassButton = new JButton("Add Method");
		addClassButton.addActionListener(toolsListener);
		this.add(addClassButton);
		
		JButton removeClassButton = new JButton("Remove Method");
		removeClassButton.addActionListener(toolsListener);
		this.add(removeClassButton);
		
		JButton addFieldButton = new JButton("Add Field");
		addFieldButton.addActionListener(toolsListener);
		this.add(addFieldButton);
		
		JButton removeFieldButton = new JButton("Remove Field");
		removeFieldButton.addActionListener(toolsListener);
		this.add(removeFieldButton);
		
		JButton removeFieldtoMethodButton = new JButton("Add Field-to-Method");
		removeFieldtoMethodButton.addActionListener(toolsListener);
		this.add(removeFieldtoMethodButton);
		
		JButton addCardinalityButton = new JButton("Add Cardinality");
		addCardinalityButton.addActionListener(toolsListener);
		this.add(addCardinalityButton);
		
		this.validate();
	}
}
