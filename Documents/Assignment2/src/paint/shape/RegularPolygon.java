package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * A closed shape with any number of vertices/edges. But unlike the Polygon,
 * this shape has equal side lengths.
 *
 */
public class RegularPolygon extends Drawable {

	private int numberOfPoints;
	private Point center;
	private Vector direction;
	private double radius;
	private ArrayList<Point> vertices;
	
	public RegularPolygon(Point center, int numberOfPoints) {
		this.center = center;
		this.numberOfPoints = numberOfPoints;
		this.vertices = new ArrayList<Point>();
	}
	
	public ArrayList<Point> getVertices() {
		return this.vertices;
	}
	
	
	/**
	 * @param radius	the new distance between this.center and the vertices
	 */
	public void setRadius(double radius) {
		this.radius = radius;
		resetVertices();
	}
	
	/**
	 * @param direction	the new direction where one vertex lies
	 */
	public void setDirection(Vector direction) {
		this.direction = direction;
		resetVertices();
	}
	
	/**
	 * Recomputes this.vertices (i.e., when a new direction or radius is provided).
	 */
	private void resetVertices() {
		this.vertices.clear();
		this.vertices = Point.getRotatedAndScaledPoints(this.center, this.direction, this.radius, this.numberOfPoints);
	}
	
	/**
	 * Creates and returns a java polygon using this.vertices
	 * @return	java.awt.Polygon representation of this
	 */
	public java.awt.Polygon getRegularPolygon() {
		java.awt.Polygon polygon = new java.awt.Polygon();
		for(Point p : this.vertices)
			polygon.addPoint(p.getX(), p.getY());
		return polygon;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		configure(g2d);
		java.awt.Polygon polygon = getRegularPolygon();
		if(this.getHasFill()) g2d.fillPolygon(polygon);
		else g2d.drawPolygon(polygon);
	}

}
