package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.RegularPolygon;
import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Vector;

/**
 * Draw a RegularPolygon by updating its radius and direction as the mouse is being dragged.
 * The direction is always the vector from the center to the position of the mouse.
 *
 */
public class RegularPolygonManipulatorStrategy implements ShapeManipulatorStrategy {

	private RegularPolygon regularPolygon;	
	private Point center;
	
	private Point getPoint(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.center = getPoint(e);
		int numberOfSides = ShapeManipulatorData.getNumberofSides();
		this.regularPolygon = new RegularPolygon(getPoint(e), numberOfSides);
		ShapeManipulatorContext.addShape(this.regularPolygon);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Vector centerToPosition = getPoint(e).subtract(this.center);
		this.regularPolygon.setDirection(centerToPosition);
		this.regularPolygon.setRadius(centerToPosition.getMagnitude());
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.regularPolygon = null;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
