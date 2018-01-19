package ca.utoronto.utm.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import ca.utoronto.utm.paint.shape.Point;
import ca.utoronto.utm.paint.shape.RegularPolygon;
import ca.utoronto.utm.paint.shape.Star;
import ca.utoronto.utm.paint.shape.Vector;

public class ShapeIcon {
	
	ArrayList<Graphics2D> shapes = new ArrayList<Graphics2D>();

	public void addToShapeChooser(JButton[] buttons) {
		for (JButton button: buttons) {
			this.shapes = bufferButtons(button);
		}
		addCircle(shapes.get(0));
		addRectangle(shapes.get(1));
		addParallelogram(shapes.get(2));
		addLine(shapes.get(3));
	}
	
	public void addToRectangle(JButton[] buttons) {
		for (JButton button: buttons) {
			this.shapes = bufferButtons(button);
		}
		addRectangle(shapes.get(0));
		addRoundRectangle(shapes.get(1));
		addSquare(shapes.get(2));
		addRoundSquare(shapes.get(3));
	}
	
	public void addToEllipse(JButton[] buttons) {
		for (JButton button: buttons) {
			this.shapes = bufferButtons(button);
		}
		addOval(shapes.get(0));
		addCircle(shapes.get(1));
	}
	
	public void addToPolygon(JButton[] buttons) {
		for (JButton button: buttons) {
			this.shapes = bufferButtons(button);
		}
		addPolygon(shapes.get(0));
		addRegularPolygon(shapes.get(1));
		addStar(shapes.get(2));

	}
	
	public void addToLine(JButton[] buttons) {
		for (JButton button: buttons) {
			this.shapes = bufferButtons(button);
		}
		addSquiggle(shapes.get(0));
		addPolyline(shapes.get(1));
	}
	

	private ArrayList<Graphics2D> bufferButtons(JButton button) {
		BufferedImage image = new BufferedImage(button.getWidth(), button.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics2D shape = image.createGraphics();
		shape.setColor(Color.BLACK);
		shape.setStroke(new BasicStroke(2));
	    button.setIcon(new ImageIcon(image));
	    shapes.add(shape);
		return shapes;
	}
	
	private void addCircle(Graphics2D shape) {
	    shape.drawOval(13,5,40,40);
	}
	
	private void addOval(Graphics2D shape) {
		shape.drawOval(13,11,40,30);
	}
	
	private void addRectangle(Graphics2D shape) {
	    shape.drawRect(8,7,40,25);
	}
	
	private void addLine(Graphics2D shape) {
		int[] xPoints = {10,15,20,25,30,35,45,75};
		int[] yPoints = xPoints;
	    shape.drawPolyline(xPoints, yPoints, 8);
	}
	
	private void addRoundRectangle(Graphics2D shape) {
		shape.drawRoundRect(8,7,40,25,15,15);
	}
	
	private void addSquare(Graphics2D shape) {
	    shape.drawRect(13,5,30,30);
	}
	
	private void addRoundSquare(Graphics2D shape) {
		shape.drawRoundRect(13,5,30,30,15,15);
	}
	
	private void addPolyline(Graphics2D shape) {
		int[] xPoints = {8,15,25,35,40,45,65,75};
		int[] yPoints = {8,15,25,35,25,15,30,45};
	    shape.drawPolyline(xPoints, yPoints, 8);
	}
	
	private void addPolygon(Graphics2D shape) {
		int [] x = {6, 12, 18, 25, 35, 55};
		int [] y = {12, 25, 35, 45, 30, 30};
		shape.drawPolygon(x, y, 6);
	}
	
	private void addParallelogram(Graphics2D shape) {
		int [] x = {8, 40, 55, 23};
		int [] y = {8, 8, 40, 40};
		shape.drawPolygon(x, y, 4);
	}

	
	private void addSquiggle(Graphics2D shape) {
		int px = 10; int py = 2;
		for (int i =2; i <9; i++) {
			shape.drawLine(px, py, i*9, i*i);
			py = i*i;
			px = i*9;
		}
	}
	
	private void addRegularPolygon(Graphics2D shape) {
		RegularPolygon regularPolygon = new RegularPolygon(new Point(27,21),5);
		regularPolygon.setDirection(new Vector(0,-1));
		regularPolygon.setRadius(20);
		shape.drawPolygon(regularPolygon.getRegularPolygon());
	}
	
	private void addStar(Graphics2D shape) {
		Star star = new Star(new Point(27,21), 5);
		star.setDirection(new Vector(0,-1));
		star.setOuterRadius(20);
		shape.drawPolygon(star.getStar());
	}
	
}
