import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import model.*;

public class GraphicalMouseMotionListener implements MouseMotionListener, MouseListener {
	private GraphicalPanel graphicalPanel;
	private ToolsPanel toolsPanel;
	private Point startDrag;
	private Classes selectedClass;
	private boolean updatedPanels = false;


	GraphicalMouseMotionListener(GraphicalPanel graphicalPanel, ToolsPanel toolsPanel) {
		this.graphicalPanel = graphicalPanel;
		this.toolsPanel = toolsPanel;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		if(this.selectedClass!=null)
		{
			if(!updatedPanels){
				toolsPanel.removeAll();
				toolsPanel.invalidate();
				toolsPanel.loadClassSelectedButtons();
				updatedPanels = true;
			}
			Point movedPoint = e.getPoint();
			movedPoint.translate(startDrag.x, startDrag.y);
			selectedClass.setPosition(movedPoint);
			graphicalPanel.repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) {
	    this.selectedClass = graphicalPanel.findNearestClass(e.getX(),e.getY());
	    this.startDrag = new Point(selectedClass.getPosition().x-e.getX(), selectedClass.getPosition().y-e.getY());
	    graphicalPanel.setMouseSelectedClass(selectedClass);
		updatedPanels = false;
	}
	
	public void mouseEntered(MouseEvent e) {};

	public void mouseExited(MouseEvent e){};

	public void mouseClicked(MouseEvent e){
		Classes clickedClass = null;
		for(Classes theClass: graphicalPanel.getDesign().getAllClasses())
		{
			if((e.getX()<(theClass.getPosition().x+(theClass.getDimension().width/2)))
				&&(e.getX()>(theClass.getPosition().x-(theClass.getDimension().width/2)))
				&&(e.getY()<(theClass.getPosition().y+(theClass.getDimension().height/2)))
				&&(e.getY()>(theClass.getPosition().y-(theClass.getDimension().height/2)))
			)
				clickedClass = theClass;
		}
		graphicalPanel.setMouseSelectedClass(clickedClass);
		toolsPanel.removeAll();
		toolsPanel.invalidate();
		if(clickedClass==null)
			toolsPanel.loadNonSelectedButtons();
		else
			toolsPanel.loadClassSelectedButtons();
		toolsPanel.repaint();
		graphicalPanel.repaint();
	}

	public void mouseReleased(MouseEvent e){
		Point movedPoint = e.getPoint();
		movedPoint.translate(startDrag.x, startDrag.y);
		selectedClass.setPosition(movedPoint);
		this.selectedClass = null;
		graphicalPanel.repaint();
	};

}
