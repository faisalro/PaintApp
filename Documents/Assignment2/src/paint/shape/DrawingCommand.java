package ca.utoronto.utm.paint.shape;

import java.awt.Color;
import java.awt.Graphics2D;

public interface DrawingCommand {
	public void draw(Graphics2D g2d);
	public void setStrokeWidth(int width);
	public void setColor(Color color);
	public void setHasFill(boolean hasFill);
}
