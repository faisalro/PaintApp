package ca.utoronto.utm.paint;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A window for the user to choose a color and to apply it to the background of
 * the PaintPanel, or to change the color of the stroke or fill.
 *
 */
public class ColorPicker extends JFrame implements ActionListener, AdjustmentListener{
	
	private static final long serialVersionUID = 1L;
	private View view;
	private Scrollbar[] scrollbars = new Scrollbar[3];	// Elements of scrollbars: 0-red, 1-green, 2-blue
	private int red, green, blue;
	private Color color;
	private Component colorPreview;
	private JPanel buttons;
	
	public ColorPicker(View view) {
		
		this.view = view;
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Panel panel = new Panel(new GridLayout(3,1,4,6));
		add(panel, BorderLayout.NORTH);
		
		
		// Construct RGB scroll bars to choose the color.
		for (int i = 0; i <3; i++) {
			scrollbars[i] = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 255);
			scrollbars[i].addAdjustmentListener(this);
			panel.add(scrollbars[i]);
		}
		scrollbars[0].setBackground(Color.RED);
		scrollbars[1].setBackground(Color.GREEN);
		scrollbars[2].setBackground(Color.BLUE); 
		
		
		// Create the buttons that apply the color.
		JButton backgroundColor = new JButton("Background Color");
		backgroundColor.setBackground(Color.LIGHT_GRAY);
		backgroundColor.addActionListener(this);
		
		JButton shapeColor = new JButton("Shape Color");
		shapeColor.setBackground(Color.LIGHT_GRAY);
		shapeColor.addActionListener(this);
		
		// Group the buttons onto a buttons JPanel.
		buttons = new JPanel();					
		buttons.setBackground(Color.BLACK);		
		buttons.add(shapeColor);
		buttons.add(backgroundColor);
		add(buttons, BorderLayout.SOUTH);
		
		
		// Construct a color preview.
		colorPreview = new Canvas();
		colorPreview.setBackground(Color.BLACK);
		colorPreview.setSize(100, 100);
		add(colorPreview, BorderLayout.CENTER);

		setLocation(700,500);
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e) {
		if(e.getSource().equals(scrollbars[0]))	red = e.getValue();
		if(e.getSource().equals(scrollbars[1]))	green = e.getValue();
		if(e.getSource().equals(scrollbars[2]))	blue = e.getValue();
		
		color = new Color(red, green, blue);
		colorPreview.setBackground(color);
		buttons.setBackground(color);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Background Color") {
			this.view.getPaintPanel().setBackground(color);
			View.setCanvasBackgroundColor(color);
		} else if (e.getActionCommand() == "Shape Color")
			this.view.getModel().setColor(color);
	}
}
