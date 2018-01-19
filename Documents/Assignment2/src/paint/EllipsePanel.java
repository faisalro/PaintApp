package ca.utoronto.utm.paint;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import ca.utoronto.utm.paint.shape.Circle;
import ca.utoronto.utm.paint.shape.Oval;

/**
 * Contains oval and circle tools.
 *
 */
public class EllipsePanel extends ShapePanel {
	private View view;
	
	public EllipsePanel(View view) {	
		this.view = view;
		
		String[] buttonLabels = {Oval.class.getTypeName(), Circle.class.getTypeName()};
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
		getIcon.addToEllipse(buttons);
	}
}
