package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.RoundedRectangle;

/**
 * First draws a Rectangle, then allows the user to move the mouse back towards the inside
 * of the rectangle to round the vertices. The shape is finished when mouseClicked is executed.
 *
 */
public class RoundedRectangleManipulatorStrategy extends RectangleManipulatorStrategy {
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (this.shape == null) return;
		
		// The point (midX, midY) is the center of the rectangle shape.
		int midX = this.origin.getX() + this.shape.getWidth() / 2;
		int midY = this.origin.getY() + this.shape.getHeight() / 2;
		
		int x = e.getX();
		int y = e.getY();
		
		int arcWidth = Math.abs(x - midX);
		int arcHeight = Math.abs(y - midY);
		
		// If cursor is outside of rectangle, then no roundness.
		if(arcWidth >= this.shape.getWidth()/2 || arcHeight >= this.shape.getHeight()/2) {
			arcWidth = 0;
			arcHeight = 0;
		} else {
			arcWidth = this.shape.getWidth() - 2*arcWidth;
			arcHeight = this.shape.getHeight() - 2*arcHeight;
		}
		
		((RoundedRectangle)this.shape).setRoundness(arcWidth, arcHeight);
		ShapeManipulatorContext.modelChanged();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseReleased(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(this.shape != null) return;
		this.origin = new Point(e.getX(), e.getY());
		this.fixedPoint = new Point(e.getX(), e.getY());
		this.shape = new RoundedRectangle(this.origin, 0, 0);
		ShapeManipulatorContext.addShape(this.shape);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
