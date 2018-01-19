package ca.utoronto.utm.paint.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * Stores and sets the color and strokeWidth of each shape to be drawn. 
 *
 */
public abstract class Drawable implements DrawingCommand {
	
	private Color color;
	private int strokeWidth;
	private boolean isSolid;
	
	protected boolean getHasFill() {
		return this.isSolid;
	}
	
	protected int getStrokeWidth() {
		return this.strokeWidth;
	}
	
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void setStrokeWidth(int width) {
		this.strokeWidth = width;
	}
	
	@Override
	public void setHasFill(boolean fill) {
		this.isSolid = fill;
	}
	
	/**
	 * Set g2d to the proper stroke width and color to draw the current shape
	 * @param g2d	the current Graphics2D used to draw shapes
	 */
	protected void configure(Graphics2D g2d) {
		try {
			g2d.setStroke(new BasicStroke(this.strokeWidth));
		} catch(Exception e) {}
		g2d.setColor(this.color);
	}
	
}