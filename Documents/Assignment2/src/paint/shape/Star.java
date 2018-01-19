package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * A star is constructed using two RegularPolygons with the same center with one slightly rotated
 * (the amount one of the RegularPolygons is rotated is precisely pi divided by the number of points
 * on the star). The corners of each RegularPolygon is interweaved with each other with one RegularPolygon
 * smaller than the other. This is how the star is created.
 *
 */
public class Star extends Drawable {

	private int numberOfPoints;
	private RegularPolygon outerRegularPolygon;
	private RegularPolygon innerRegularPolygon;
	
	public Star(Point center, int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
		outerRegularPolygon = new RegularPolygon(center, this.numberOfPoints);
		innerRegularPolygon = new RegularPolygon(center, this.numberOfPoints);
	}
	
	/**
	 * @param radius	the new radius for the outerRegularPolygon
	 */
	public void setOuterRadius(double radius) {
		this.outerRegularPolygon.setRadius(radius);
		setInnerRadius(radius / 2);
	}
	
	/**
	 * @param radius	the new radius for the innerRegularPolygon
	 */
	public void setInnerRadius(double radius) {
		this.innerRegularPolygon.setRadius(radius);
	}
	
	/**
	 * Sets the direction of innerRegularPolygon and outerRegularPolygon.
	 * @param direction	the new direction for this
	 */
	public void setDirection(Vector direction) {
		this.outerRegularPolygon.setDirection(direction);
		this.innerRegularPolygon.setDirection(direction.rotate(Math.PI / this.numberOfPoints));
	}
	
	/**
	 * @return	java.awt.Polygon representation of this
	 */
	public java.awt.Polygon getStar() {
		java.awt.Polygon polygon = new java.awt.Polygon();
		for(Point p : interweavePoints())
			polygon.addPoint(p.getX(), p.getY());
		return polygon;
	}
	
	/**
	 * Get an ArrayList<Point> such that consecutive points in the ArrayList are consecutive points on the Star.
	 * @return ArrayList<Point> containing all vertices from innerRegularPolygon and outerRegularPolygon
	 */
	private ArrayList<Point> interweavePoints() {
		ArrayList<Point> outerRegularPolygonVertices = this.outerRegularPolygon.getVertices();
		ArrayList<Point> innerRegularPolygonVertices = this.innerRegularPolygon.getVertices();
		ArrayList<Point> interweaveVertices = new ArrayList<Point>();
		
		for(int i = 0; i < innerRegularPolygonVertices.size(); i++) {
			interweaveVertices.add(outerRegularPolygonVertices.get(i));
			interweaveVertices.add(innerRegularPolygonVertices.get(i));
		}
		return interweaveVertices;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		configure(g2d);
		java.awt.Polygon star = getStar();
		if(this.getHasFill()) g2d.fillPolygon(star);
		else g2d.drawPolygon(star);
	}
	
}
