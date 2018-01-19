package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Drawable;
import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Rectangle;
import ca.utoronto.utm.paint.shape.RoundedRectangle;
import ca.utoronto.utm.paint.shape.RoundedSquare;
import ca.utoronto.utm.paint.shape.Square;

/**
 * Draws a square similar to how rectangle is drawn. But sets only a single length
 * rather than a width and a height.
 *
 */
public class SquareManipulatorStrategy implements ShapeManipulatorStrategy {
	
	protected Square shape;
	protected Point origin;
	protected Point fixedPoint; // The point where the user first clicks.
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.origin = new Point(e.getX(), e.getY());
		this.fixedPoint = new Point(e.getX(), e.getY());
		this.shape = new Square(this.origin, 0);
		ShapeManipulatorContext.addShape(this.shape);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		int fixedX = this.fixedPoint.getX();
		int fixedY = this.fixedPoint.getY();
		
		int length = Math.max(Math.abs(x - fixedX), Math.abs(y - fixedY));
		
		if(x < fixedX) this.origin.setX(fixedX-length);
		else this.origin.setX(fixedX);
		
		if(y < fixedY) this.origin.setY(fixedY-length);
		else this.origin.setY(fixedY);
		
		this.shape.setLength(length);
		
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.shape = null;
		this.origin = this.fixedPoint = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
