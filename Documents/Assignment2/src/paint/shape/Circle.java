package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * Represents a circle using a center and radius.
 *
 */
public class Circle extends Drawable implements DrawingCommand {
	
	private Point center;
	private int radius;
	
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		int x = this.center.getX();
		int y = this.center.getY();
		int radius = getRadius();
		int strokeWidth = getStrokeWidth();
		
		if(strokeWidth/2 > radius) // Prevents stroke from overlapping with itself by using fill instead of draw.
			g2d.fillOval(x-radius-strokeWidth/2, y-radius-strokeWidth/2, radius*2+strokeWidth, radius*2+strokeWidth);
		else if (getHasFill()) g2d.fillOval(x-radius, y-radius, radius*2, radius*2);
		else g2d.drawOval(x-radius, y-radius, radius*2, radius*2);
	}
}
