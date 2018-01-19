package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Drawable;
import ca.utoronto.utm.paint.shape.Oval;
import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Rectangle;
import ca.utoronto.utm.paint.shape.RoundedRectangle;

/**
 * Draws a rectangle by moving around the origin as the user drags and setting
 * the width and length as appropriate.
 *
 */
public class RectangleManipulatorStrategy implements ShapeManipulatorStrategy {
	
	protected Point origin;
	protected Point fixedPoint; // The point where the user first clicks.
	protected Rectangle shape;
	
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
		this.shape = new Rectangle(this.origin, 0, 0);
		ShapeManipulatorContext.addShape(this.shape);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		int fixedX = this.fixedPoint.getX();
		int fixedY = this.fixedPoint.getY();
		
		if(x < fixedX) this.origin.setX(x);
		else this.origin.setX(fixedX);
		
		if(y < fixedY) this.origin.setY(y);
		else this.origin.setY(fixedY);
		
		int width = Math.abs(x - fixedX);
		int height = Math.abs(y - fixedY);
		
		this.shape.setWidth(width);
		this.shape.setHeight(height);
		
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
