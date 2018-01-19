package ca.utoronto.utm.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ca.utoronto.utm.paint.shape.Eraser;

/**
 * Contains eraser and clear all buttons.
 *
 */
public class EraserAndClearPanel extends JPanel implements ActionListener{
	
	private View view;
	
	public EraserAndClearPanel (View view) {
		this.view = view;
		this.setBackground(View.PANEL_BACKGROUND_COLOR);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton clearAll = new JButton("Clear All");
		clearAll.addActionListener(this);
		clearAll.setBackground(Color.WHITE);
		add(clearAll);
		
		JButton eraser = new JButton("Eraser   ");
		eraser.addActionListener(this.view.getPaintPanel());
		eraser.setBackground(Color.WHITE);
		add(eraser);
		
		eraser.setActionCommand(Eraser.class.getTypeName());		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.getModel().clearAllShapes();
	}
}
