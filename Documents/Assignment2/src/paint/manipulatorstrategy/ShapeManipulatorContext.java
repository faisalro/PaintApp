package ca.utoronto.utm.paint.manipulatorstrategy;

import java.awt.event.MouseEvent;

import ca.utoronto.utm.paint.PaintModel;
import ca.utoronto.utm.paint.shape.Drawable;

/**
 * 
 * Context of strategy design pattern. Affects model by adding shapes
 * to PaintModel.
 *
 */
public class ShapeManipulatorContext implements ShapeManipulatorStrategy {
	
	private ShapeManipulatorStrategy strategy;
	private static PaintModel model;
	
	static void modelChanged() {
		model.modelChanged();
	}
	
	static void addShape(Drawable shape) {
		model.addShape(shape);
	}
	
	public ShapeManipulatorContext(PaintModel model) {
		this.strategy = null;
		this.model = model;
	}

	public void changeStrategy(ShapeManipulatorStrategy strategy) {
		this.strategy = strategy;
	}

	private boolean hasStrategy() {
		return strategy != null;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseMoved(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mousePressed(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseClicked(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseDragged(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseReleased(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseEntered(e);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		if (hasStrategy())
			this.strategy.mouseExited(e);
	}
}
