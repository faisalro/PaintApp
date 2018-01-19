package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * A Rectangle with rounded vertices.
 *
 */
public class RoundedRectangle extends Rectangle {

	private int arcWidth, arcHeight;
	
	public RoundedRectangle(Point origin, int width, int height) {
		super(origin, width, height);
		this.arcWidth = 0;
		this.arcHeight = 0;
	}
	
	public void setRoundness(int arcWidth, int arcHeight) {
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		// Drawn incorrectly with large stroke width and no roundness. Draws a rectangle instead.
		if (this.arcWidth == 0 && this.arcHeight == 0) { 
			super.draw(g2d);
			return;
		}
		
		this.configure(g2d);		
		int x = getOrigin().getX();
		int y = getOrigin().getY();
		int width = getWidth();
		int height = getHeight();
		if (getHasFill()) g2d.fillRoundRect(x, y, width, height, this.arcWidth, this.arcHeight);
		else g2d.drawRoundRect(x, y, width, height, this.arcWidth, this.arcHeight);
	} 
}
