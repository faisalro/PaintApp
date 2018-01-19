package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

public interface ShapeManipulatorStrategy {
	public void mouseMoved(MouseEvent e);
	public void mouseClicked(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseDragged(MouseEvent e);
	public void mouseReleased(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
}
