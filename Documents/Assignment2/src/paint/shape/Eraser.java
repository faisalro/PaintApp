package ca.utoronto.utm.paint.shape;

import java.awt.Graphics2D;
import ca.utoronto.utm.paint.View;

/**
 * Draws a Squiggle with a color that is always equal to the background color.
 *
 */
public class Eraser extends Squiggle {
	
	@Override
	public void draw(Graphics2D g2d) {
		this.setColor(View.getCanvasBackgroundColor());
		configure(g2d);
		
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
