package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Squiggle;

/**
 * Draws a squiggle by adding points every time the mouse is dragged.
 *
 */
public class SquiggleManipulatorStrategy implements ShapeManipulatorStrategy{

	private Squiggle shape;
	
	protected void addPoint(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		this.shape.addPoint(new Point(x, y));
	}
	
	protected void setShape(Squiggle shape) {
		this.shape = shape;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.shape = new Squiggle();
		ShapeManipulatorContext.addShape(this.shape);
		addPoint(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		addPoint(e);
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.shape = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
