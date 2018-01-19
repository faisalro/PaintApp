package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Star;
import ca.utoronto.utm.paint.shape.Vector;

/**
 * Draws a star by constantly updating two RegularPolygons. First, the outer
 * RegularPolygon is set during mouseDragged. The inner RegularPolygon is set
 * in mouseMoved. The star is completed when mouseClicked executes.
 *
 */
public class StarManipulatorStrategy implements ShapeManipulatorStrategy {
	
	private Star star;
	private Point center;
	
	private Point getPoint(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(this.star == null) return;
		Vector centerToPosition = getPoint(e).subtract(this.center);
		this.star.setInnerRadius(centerToPosition.getMagnitude());
		ShapeManipulatorContext.modelChanged();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.star = null;
		this.center = null;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(this.star != null) return;
		this.center = getPoint(e);
		this.star = new Star(this.center, ShapeManipulatorData.getNumberofSides());
		ShapeManipulatorContext.addShape(this.star);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Vector centerToPosition = getPoint(e).subtract(this.center);
		this.star.setDirection(centerToPosition);
		this.star.setOuterRadius(centerToPosition.getMagnitude());
		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
