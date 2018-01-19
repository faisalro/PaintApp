package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.Polygon;
import ca.utoronto.utm.paint.shape.Polyline;

/**
 * Draws a polyline by setting a dynamicPoint and moving it around
 * to update the model (and hence the PaintPanel).
 *
 */
public class PolylineManipulatorStrategy implements ShapeManipulatorStrategy {

	private Polyline polyline;
	private Point dynamicPoint;
	
	public PolylineManipulatorStrategy() {
		this.polyline = new Polyline();
	}
	
	protected PolylineManipulatorStrategy(Object type) {
		if(PolygonManipulatorStrategy.class.equals(type))
			this.polyline = new Polygon();
	}
	
	private Point getPoint(MouseEvent e) {
		return new Point(e.getX(), e.getY());
	}
	
	private void setDynamicPoint(MouseEvent e) {
		Point p = getPoint(e);
		this.dynamicPoint.setX(p.getX());
		this.dynamicPoint.setY(p.getY());
		ShapeManipulatorContext.modelChanged();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(this.polyline.getPointCount() == 0)
			ShapeManipulatorContext.addShape(this.polyline);
		
		this.dynamicPoint = getPoint(e);
		this.polyline.addPoint(this.dynamicPoint);

		ShapeManipulatorContext.modelChanged();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setDynamicPoint(e);
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
