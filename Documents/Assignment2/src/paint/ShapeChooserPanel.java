package ca.utoronto.utm.paint;

import javax.swing.*;

import ca.utoronto.utm.paint.shape.Squiggle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contains buttons to choose the shape panel to be displayed.
 *
 */
class ShapeChooserPanel extends ShapePanel {
	
	private View view;
	
	public ShapeChooserPanel(View view) {
		this.view = view;
		
		String[] buttonLabels = { EllipsePanel.class.getTypeName(), QuadrilateralPanel.class.getTypeName()
						, PolygonPanel.class.getTypeName(), LinePanel.class.getTypeName() };
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton[] buttons = new JButton[buttonLabels.length];
		setupPanel(buttonLabels, buttons);
		for (JButton button: buttons) {
			button.addActionListener(this.view.getPaintPanel());
		}
		JLabel emptySpace = new JLabel();
		emptySpace.setText(" ");	add(emptySpace);
		EraserAndClearPanel moreOptionsPanel = new EraserAndClearPanel(view);
		add(moreOptionsPanel);
		
	}
	
	@Override
	public void setBounds(JButton button) {
		button.setBounds(0, 180, 60, 60);
	}
	
	@Override
	public void addShapeToIcon(JButton[] buttons) {
		ShapeIcon getIcon = new ShapeIcon();
		getIcon.addToShapeChooser(buttons);
	}

}

