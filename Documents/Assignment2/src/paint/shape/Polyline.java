package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * A collection of points drawn by connecting consecutive points with
 * a straight line.
 *
 */
public class Polyline extends Drawable implements DrawingCommand {
	
	private ArrayList<Point> points = new ArrayList<Point>();
	
	protected ArrayList<Point> getPoints(){
		return points;
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
	
	public int getPointCount() {
		return this.points.size();
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
