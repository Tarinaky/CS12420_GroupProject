import javax.swing.*;
import model.*;
import javax.swing.border.Border;
import java.awt.*;

import javax.swing.border.*;

public class ToolsPanel extends JPanel{
	private GraphicalPanel graphicalPanel;
	private Design design;
	private ClassActionListener toolsListener;

	ToolsPanel(Design design, GraphicalPanel graphicalPanel)
	{
		this.design = design;
		this.graphicalPanel = graphicalPanel;
		this.setSize(900, 200);
		this.setPreferredSize(new Dimension(900, 135));
		this.setBackground(Color.ORANGE);
		this.setLayout(new FlowLayout());
		toolsListener = new ClassActionListener(design, graphicalPanel);
		loadNonSelectedButtons();
	}
	
	public void loadNonSelectedButtons()
	{
		JButton addClassButton = new JButton("Add Class");
		addClassButton.addActionListener(toolsListener);
		//this.add(addClassButton);
		JButton removeClassButton = new JButton("Remove Class");
		removeClassButton.addActionListener(toolsListener);
		//this.add(removeClassButton);
		
		JPanel addingPanel = new JPanel();
		addingPanel.setBackground(Color.orange);
		JLabel atLabel = new JLabel("Add: ");
		addingPanel.add(atLabel);
		addingPanel.add(addClassButton);
		
		JPanel removingPanel = new JPanel();
		removingPanel.setBackground(Color.orange);
		JLabel rtLabel = new JLabel("Remove: ");
		
		removingPanel.add(rtLabel);
		removingPanel.add(removeClassButton);
		this.add(addingPanel);
		this.add(removingPanel);
		
		this.validate();
	}
	
	public void loadClassSelectedButtons()
	{
		
		JButton addClassButton = new JButton("Add Method");
		addClassButton.addActionListener(toolsListener);
		//this.add(addClassButton);
		
		JButton removeClassButton = new JButton("Remove Method");
		removeClassButton.addActionListener(toolsListener);
		//this.add(removeClassButton);
		
		JButton addFieldButton = new JButton("Add Field");
		addFieldButton.addActionListener(toolsListener);
		//this.add(addFieldButton);
		
		JButton removeFieldButton = new JButton("Remove Field");
		removeFieldButton.addActionListener(toolsListener);
		//this.add(removeFieldButton);
		
		JButton addFieldtoMethodButton = new JButton("Add Field-to-Method");
		addFieldtoMethodButton.addActionListener(toolsListener);
		//this.add(removeFieldtoMethodButton);
		
		JButton removeFieldToMethodButton = new JButton("Remove Field-from-Method");
		removeFieldToMethodButton.addActionListener(toolsListener);
		
		JButton addCardinalityButton = new JButton("Add Cardinality");
		addCardinalityButton.addActionListener(toolsListener);
		//this.add(addCardinalityButton);
		
		JButton removeCardinalityButton = new JButton("Remove Cardinality");
		removeCardinalityButton.addActionListener(toolsListener);
		
		JButton editNameButton = new JButton("Edit Class Name");
		editNameButton.addActionListener(toolsListener); 
		
		JButton editFieldButton = new JButton("Edit Field");
		editFieldButton.addActionListener(toolsListener);
		
		JButton editMethodButton = new JButton("Edit Method");
		editMethodButton.addActionListener(toolsListener);
		
		JButton editFieldToMethodButton = new JButton("Edit Fields-in-Method");
		editFieldToMethodButton.addActionListener(toolsListener);
		
		JButton editCardinalityButton = new JButton("Edit Cardinality");
		editCardinalityButton.addActionListener(toolsListener);
		
		JPanel addingPanel = new JPanel();
		addingPanel.setBackground(Color.orange);
		JLabel atLabel = new JLabel("Add: ");
		
		addingPanel.add(atLabel);
		addingPanel.add(addClassButton);
		addingPanel.add(addFieldButton);
		addingPanel.add(addFieldtoMethodButton);
		addingPanel.add(addCardinalityButton);
		
		JPanel removingPanel = new JPanel();
		removingPanel.setBackground(Color.orange);
		JLabel rtLabel = new JLabel("Remove: ");
		
		removingPanel.add(rtLabel);
		removingPanel.add(removeClassButton);
		removingPanel.add(removeFieldButton);
		removingPanel.add(removeFieldToMethodButton);
		removingPanel.add(removeCardinalityButton);
		
		JPanel editPanel = new JPanel();
		editPanel.setBackground(Color.orange);
		JLabel editLabel = new JLabel("Edit: ");
		
		editPanel.add(editLabel);
		editPanel.add(editNameButton);
		editPanel.add(editFieldButton);
		editPanel.add(editMethodButton);
		editPanel.add(editFieldToMethodButton);
		editPanel.add(editCardinalityButton);
		
		this.add(addingPanel);
		this.add(editPanel);
		this.add(removingPanel);

		this.validate();
	}
}
