package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Eraser;

/**
 * Draws exactly the same as squiggle.
 *
 */
public class EraserManipulatorStrategy extends SquiggleManipulatorStrategy {
	
	@Override
	public void mousePressed(MouseEvent e) {
		Eraser eraser = new Eraser();
		setShape(eraser);
		ShapeManipulatorContext.addShape(eraser);
		addPoint(e);
	}
	
}
