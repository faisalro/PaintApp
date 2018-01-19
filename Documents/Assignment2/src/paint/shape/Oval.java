package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;

/**
 * Represents the rectangular bounding box for an oval. 
 *
 */
public class Oval extends Rectangle {

	public Oval(Point origin, int width, int height) {
		super(origin, width, height);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		this.configure(g2d);
		int x = getOrigin().getX();
		int y = getOrigin().getY();
		int width = getWidth();
		int height = getHeight();
		int strokeWidth = getStrokeWidth();
		
		if (getHasFill()) g2d.fillOval(x, y, width, height);
		else {
			if(width < strokeWidth || height < strokeWidth)	// Fill in center of oval if stroke overlaps with itself.
				g2d.fillOval(x-strokeWidth/2, y-strokeWidth/2, width+strokeWidth, height+strokeWidth);
			g2d.drawOval(x, y, width, height);
		}
	}

}
