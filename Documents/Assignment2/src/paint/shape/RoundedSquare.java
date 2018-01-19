package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * A Square with rounded vertices.
 *
 */
public class RoundedSquare extends Square {

	private int arcWidth, arcHeight;
	
	public RoundedSquare(Point point, int length) {
		super(point, length);
		this.arcWidth = 0;
		this.arcHeight = 0;
	}

	public void setRoundness(int arcWidth, int arcHeight) {
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
	}
	
	@Override
	public void draw(Graphics2D g2d) { 
		// Drawn incorrectly with large stroke width and no roundness.
		if (this.arcWidth == 0 && this.arcHeight == 0) {
			super.draw(g2d);
			return;
		}
		
		this.configure(g2d);		
		int x = this.getOrigin().getX();
		int y = this.getOrigin().getY();
		if (getHasFill()) g2d.fillRoundRect(x, y, getLength(), getLength(), this.arcWidth, this.arcHeight);
		else g2d.drawRoundRect(x, y, getLength(), getLength(), this.arcWidth, this.arcHeight);
	}

}
