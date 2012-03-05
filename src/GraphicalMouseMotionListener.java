import java.awt.*;
import java.awt.event.*;

import javax.swing.SwingUtilities;

import model.*;

public class GraphicalMouseMotionListener implements MouseMotionListener, MouseListener {
	private GraphicalPanel graphicalPanel;
	private Point startDrag;
	public Classes selectedClass;

	GraphicalMouseMotionListener(GraphicalPanel graphicalPanel) {
		this.graphicalPanel = graphicalPanel;
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		if(this.selectedClass!=null)
		{
			Point movedPoint = e.getPoint();
			movedPoint.translate(startDrag.x, startDrag.y);
			selectedClass.setPosition(movedPoint);
			graphicalPanel.repaint();
		}
	}
	
	public void mousePressed(MouseEvent e) {
	    this.selectedClass = graphicalPanel.findNearestClass(e.getX(),e.getY());
	    this.startDrag = new Point(selectedClass.getPosition().x-e.getX(), selectedClass.getPosition().y-e.getY());
	}
	
	public void mouseEntered(MouseEvent e) {};

	public void mouseExited(MouseEvent e){};

	public void mouseClicked(MouseEvent e){};

	public void mouseReleased(MouseEvent e){
		this.selectedClass = null;
	};

}
