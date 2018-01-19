package ca.utoronto.utm.paint;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import ca.utoronto.utm.paint.shape.Polyline;
import ca.utoronto.utm.paint.shape.Squiggle;

/**
 * Gives access to polyline and squiggle.
 *
 */
public class LinePanel extends ShapePanel {
	private View view;
	
	public LinePanel(View view) {	
		this.view = view;
		
		String[] buttonLabels = { Squiggle.class.getTypeName(), Polyline.class.getTypeName(),};
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton[] buttons = new JButton[2];
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
		getIcon.addToLine(buttons);
	}
}
