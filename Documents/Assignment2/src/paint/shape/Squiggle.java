package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * A collection of points drawn with a straight line between consecutive points.
 *
 */
public class Squiggle extends Drawable implements DrawingCommand {
	
	protected ArrayList<Point> points;

	public Squiggle() {
		this.points = new ArrayList<Point>();
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		int nPoints = this.points.size();
		int[] xPoints = new int[nPoints];
		int[] yPoints = new int[nPoints];
		
		for (int i = 0; i < nPoints; i++) {
			xPoints[i] = getPoints().get(i).getX();
			yPoints[i] = getPoints().get(i).getY();
		}
		g2d.drawPolyline(xPoints, yPoints, nPoints);
	}
}
