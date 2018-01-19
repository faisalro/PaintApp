package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Stack;

import ca.utoronto.utm.paint.shape.Drawable;
import ca.utoronto.utm.paint.shape.DrawingCommand;

/**
 * Contains all drawn shapes, sets the color, width, and fill of new shapes,
 * and has methods for undo, redo, and clearAllShapes.
 *
 */
public class PaintModel extends Observable implements DrawingCommand {
	
	private Color color;
	private int strokeWidth;
	private boolean hasFill;
	
	private Stack<Drawable> shapes = new Stack<Drawable>();
	private Stack<Stack<Drawable>> deletedShapeGroups = new Stack<Stack<Drawable>>();
	
	/**
	 * Configures shape with the current color, width, and hasFill and
	 * pushes shape to shapes. modelChanged() causes this shape to be
	 * immediately drawn on the PaintPanel.
	 * @param shape	a newly drawn shape
	 */
	public void addShape(Drawable shape) {
		shape.setColor(this.color);
		shape.setStrokeWidth(this.strokeWidth);
		shape.setHasFill(this.hasFill);
		this.shapes.push(shape);
		this.deletedShapeGroups.clear();
		modelChanged();
	}
	
	/**
	 * Removes all shapes from shapes and puts it into a new
	 * sub-stack in deletedShapeGroups. This allows redo() to
	 * get back all the cleared shapes.
	 */
	public void clearAllShapes() {
		if(this.shapes.size() == 0) return;
		Stack<Drawable> shapes = new Stack<Drawable>();
		while(!this.shapes.isEmpty())
			shapes.push(this.shapes.pop());
		this.deletedShapeGroups.push(shapes);
		modelChanged();
	}
	
	/**
	 * Remove the most recently drawn shape, if it exists. Adds a stack
	 * containing only that shape to deletedShapeGroups.
	 */
	public void undo() {
		if(this.shapes.size() == 0) return;
		Stack<Drawable> shapes = new Stack<Drawable>();
		shapes.push(this.shapes.pop());
		this.deletedShapeGroups.push(shapes);
	}
	
	/**
	 * Adds the most recently deleted shape(s), if they exist, back to shapes.
	 */
	public void redo() {
		if(this.deletedShapeGroups.size() == 0) return;
		Stack<Drawable> shapes = this.deletedShapeGroups.pop();
		while(!shapes.isEmpty())
			this.shapes.push(shapes.pop());
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		for(Drawable shape : this.shapes)
			shape.draw(g2d);
	}
	
	@Override
	public void setStrokeWidth(int width) {
		this.strokeWidth = width;
	}
	
	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void setHasFill(boolean hasFill) {
		this.hasFill = hasFill;
	}
	
	public void modelChanged() {
		this.setChanged();
		this.notifyObservers();
	}
}
