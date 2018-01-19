package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * A rectangle with its origin at its top left vertex.
 *
 */
public class Rectangle extends Drawable implements DrawingCommand {
    
	private int width;
    private int height;
    private Point origin;
    
    public Rectangle(Point origin, int width, int height) {
        this.origin = origin;
        this.width = width;
        this.height = height;
    }
    
    public Point getOrigin() {
    	return origin;
    }
    
    public int getWidth() {
    	return width;
    }
    
    public void setHeight(int height) {
    	this.height = height;
    }
    
    public int getHeight() {
    	return height;
    }
    
    public void setWidth(int width) {
    	this.width = width;
    }

	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		int x = this.origin.getX();
		int y = this.origin.getY();
		if (getHasFill()) g2d.fillRect(x, y, this.width, this.height);
		else g2d.drawRect(x, y, this.width, this.height);
	}
}