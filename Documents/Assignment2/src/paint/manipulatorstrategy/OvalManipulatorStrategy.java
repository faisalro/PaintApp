package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Oval;
import ca.utoronto.utm.paint.shape.Point;

/**
 * Draws exactly the same as Rectangle.
 *
 */
public class OvalManipulatorStrategy extends RectangleManipulatorStrategy {

	@Override
	public void mousePressed(MouseEvent e) {
		this.origin = new Point(e.getX(), e.getY());
		this.fixedPoint = new Point(e.getX(), e.getY());
		this.shape = new Oval(this.origin, 0, 0);
		ShapeManipulatorContext.addShape(this.shape);
	}

}
