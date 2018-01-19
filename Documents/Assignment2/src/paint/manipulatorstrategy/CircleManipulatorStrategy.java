package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Circle;
import ca.utoronto.utm.paint.shape.Point;

/**
 * Draws a circle by setting its center and changing its radius as the user
 * drags away from the center.
 *
 */
public class CircleManipulatorStrategy implements ShapeManipulatorStrategy {

	private Circle circle;
	
	private int pythagoreanRadius(MouseEvent e) {
		int x = this.circle.getCenter().getX()-e.getX();
		int y = this.circle.getCenter().getY()-e.getY();
		return (int) Math.pow(x*x + y*y, .5);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point center = new Point(e.getX(), e.getY());
		this.circle=new Circle(center, 0);
		ShapeManipulatorContext.addShape(this.circle);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int radius = pythagoreanRadius(e);
		this.circle.setRadius(radius);
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.circle = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
