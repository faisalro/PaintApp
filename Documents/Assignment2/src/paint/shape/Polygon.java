package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * 
 * A closed shape with any finite number of vertices or edges.
 *
 */
public class Polygon extends Polyline {
	
	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		java.awt.Polygon polygon = new java.awt.Polygon();
		for(Point p : getPoints())
			polygon.addPoint(p.getX(), p.getY());
		if(this.getHasFill()) g2d.fillPolygon(polygon);
		else g2d.drawPolygon(polygon);
	}
	
}
