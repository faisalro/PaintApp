package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * A square with its origin at its top left vertex.
 *
 */
public class Square extends Drawable implements DrawingCommand {
	
	private Point origin;
	private int length;

	public Square(Point point, int length) {
		this.origin = point;
		this.length = length;
	}
	
	public void setLength(int len) {
		length = len;
	}
	
	public int getLength() {
		return length;
	}
	
	public Point getOrigin() {
	    return origin;
	}

	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		int x = this.origin.getX();
		int y = this.origin.getY();
		if (getHasFill()) g2d.fillRect(x, y, this.length, this.length);
		else g2d.drawRect(x, y, this.length, this.length);
	}
}
