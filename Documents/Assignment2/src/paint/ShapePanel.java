package ca.utoronto.utm.paint;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * The base panel extended by each ShapePanel (i.e., EllipsePanel, LinePanel,
 * PolygonPanel, and QuadrilateralPanel).
 *
 */
public class ShapePanel extends JPanel {
	
	private ButtonSelectColorActionListener selection;
	
	public ShapePanel() {
		setBackground(View.PANEL_BACKGROUND_COLOR);
	}
	
	public void setupPanel(String[] buttonLabels, JButton[] buttons) {
		selection = new ButtonSelectColorActionListener();
		int i = 0;
		for (String label : buttonLabels) {
			JButton button = new JButton();
			button.setActionCommand(label);
			setBounds(button);
			this.add(button);
			button.setBackground(View.BUTTON_UNSELECTED_BACKGROUND_COLOR);
			button.addActionListener(selection);	
			buttons[i] = button;
			i += 1;
		}
		addShapeToIcon(buttons);
	}
	
	public void setBounds(JButton button) {
		
	}
	
	public void addShapeToIcon(JButton[] buttons) {
		
	}
	
	public void resetButtons() {
		this.selection.actionPerformed(null);
	}
	
}
