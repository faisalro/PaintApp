package ca.utoronto.utm.paint;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import ca.utoronto.utm.paint.shape.Rectangle;
import ca.utoronto.utm.paint.shape.RoundedRectangle;
import ca.utoronto.utm.paint.shape.RoundedSquare;
import ca.utoronto.utm.paint.shape.Square;

/**
 * Contains square, rectangle, rounded square, and rounded rectangle tools.
 *
 */
public class QuadrilateralPanel extends ShapePanel {
	private View view;
	
	public QuadrilateralPanel(View view) {	
		this.view = view;
		
		String[] buttonLabels = { Rectangle.class.getTypeName(), RoundedRectangle.class.getTypeName(),
									Square.class.getTypeName(), RoundedSquare.class.getTypeName()};
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton[] buttons = new JButton[buttonLabels.length];
		setupPanel(buttonLabels, buttons);
		for (JButton button: buttons) {
			button.addActionListener(this.view.getPaintPanel());
		}
	}
	
	@Override
	public void setBounds(JButton button) {
		button.setBounds(button.getX(), button.getY(), 60, 50);
	}
	
	@Override
	public void addShapeToIcon(JButton[] buttons) {
		ShapeIcon getIcon = new ShapeIcon();
		getIcon.addToRectangle(buttons);
	}
}
