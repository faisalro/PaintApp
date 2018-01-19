package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Used to visually show that a button has been selected and/or deselected.
 *
 */
public class ButtonSelectColorActionListener implements ActionListener {
	
	private JButton button;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (button != null)
			button.setBackground(View.BUTTON_UNSELECTED_BACKGROUND_COLOR);
		if (e != null) {
			button = (JButton)e.getSource();
			button.setBackground(View.BUTTON_SELECTED_BACKGROUND_COLOR);
		}
	}
}
