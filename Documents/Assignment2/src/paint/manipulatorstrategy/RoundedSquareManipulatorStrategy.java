package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.RoundedRectangle;
import ca.utoronto.utm.paint.shape.RoundedSquare;

/**
 * First draws a square, then allows the user to move the mouse to the inside of
 * the square to round the vertices. The shape is completed when mouseClicked executes.
 *
 */
public class RoundedSquareManipulatorStrategy extends SquareManipulatorStrategy {

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (this.shape == null) return;
		
		int length = this.shape.getLength();
		
		// The point (midX, midY) is the center of the rectangle shape.
		int midX = this.origin.getX() + length / 2;
		int midY = this.origin.getY() + length / 2;
		
		int x = e.getX();
		int y = e.getY();
		
		int arcWidth = Math.abs(x - midX);
		int arcHeight = Math.abs(y - midY);
		
		// If cursor is outside of rectangle, then no roundness.
		if(arcWidth >= length/2 || arcHeight >= length/2) {
			arcWidth = 0;
			arcHeight = 0;
		} else {
			arcWidth = length - 2*arcWidth;
			arcHeight = length - 2*arcHeight;
		}
		
		((RoundedSquare)this.shape).setRoundness(arcWidth, arcHeight);
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
		this.shape = new RoundedSquare(this.origin, 0);
		ShapeManipulatorContext.addShape(this.shape);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
}
