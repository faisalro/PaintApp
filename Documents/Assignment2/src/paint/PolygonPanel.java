package ca.utoronto.utm.paint;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ca.utoronto.utm.paint.manipulatorstrategy.ShapeManipulatorData;
import ca.utoronto.utm.paint.shape.Polygon;
import ca.utoronto.utm.paint.shape.Polyline;
import ca.utoronto.utm.paint.shape.RegularPolygon;
import ca.utoronto.utm.paint.shape.Star;

/**
 * Contains Polygon, RegularPolygon, and Star tools.
 *
 */
public class PolygonPanel extends ShapePanel implements ActionListener{
	
	private View view;
	private JTextField numberOfSides;
	
	public PolygonPanel(View view) {	
		this.view = view;
		String[] buttonLabels = { Polygon.class.getTypeName(), RegularPolygon.class.getTypeName(), 
									Star.class.getTypeName()};
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton[] buttons = new JButton[buttonLabels.length];
		setupPanel(buttonLabels, buttons);
		for (JButton button: buttons) {
			button.addActionListener(this.view.getPaintPanel());
			button.addActionListener(this);
		}
		
		JLabel label = new JLabel();
		label.setText(" # of Points:");
		add(label);
		this.numberOfSides = new JTextField(Integer.toString(ShapeManipulatorData.getNumberofSides()));
		this.numberOfSides.setMaximumSize(new Dimension(200, 25));
		this.numberOfSides.setAlignmentX(Component.LEFT_ALIGNMENT);	 // Component alignment
		this.numberOfSides.setHorizontalAlignment(JTextField.CENTER); // Text alignment
		this.numberOfSides.addActionListener(this);
		this.numberOfSides.setEnabled(false);
		add(this.numberOfSides);
	}
	
	@Override
	public void setBounds(JButton button) {
		button.setBounds(button.getX(), button.getY(), 60, 50);
	}
	
	@Override
	public void addShapeToIcon(JButton[] buttons) {
		ShapeIcon getIcon = new ShapeIcon();
		getIcon.addToPolygon(buttons);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (e.getActionCommand() == RegularPolygon.class.getTypeName() ||
					e.getActionCommand() == Star.class.getTypeName())
				this.numberOfSides.setEnabled(true);
			else this.numberOfSides.setEnabled(false);
		}
		else if (e.getSource().equals(this.numberOfSides)) {
			try {
				int numberOfSides = Integer.parseInt(this.numberOfSides.getText());
				ShapeManipulatorData.setNumberOfSides(numberOfSides);
			} catch (NumberFormatException numberFormatException) {
				this.numberOfSides.setText(Integer.toString(ShapeManipulatorData.getNumberofSides()));
			}
		}
	}
	
}
