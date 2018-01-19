package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Contains controls to let the user adjust color, stroke width, and fill or outline.
 *
 */
public class DrawStylePanel extends JPanel implements ActionListener, ChangeListener {

	private JTextField strokeWidthTf;
	private JSlider strokeWidthSlider;
	private JButton colors;
	private JRadioButton outline;
	private JRadioButton fill;

	private View view;
	
	public DrawStylePanel(View view) {
		
		this.view = view;;
		setBackground(View.getCanvasBackgroundColor());		
		
		
		// Construct stroke width label and textbox.
		JLabel sizeLabel = new JLabel();
		sizeLabel.setText("Line Width");
		add(sizeLabel);
		
		strokeWidthTf = new JTextField(3);
		strokeWidthTf.setHorizontalAlignment(JTextField.CENTER);
		strokeWidthTf.addActionListener(this);
		add(strokeWidthTf);
		
		
		
		// Construct stroke width slider.
		final int sliderMinWidth = 0;
		final int sliderMaxWidth = 100;
		final int sliderInitialWidth = 2;
		final int sliderMajorSpacing = 25;
		final int sliderMinorSpacing = 5;
		final boolean sliderShowTicks = true;
		final boolean sliderShowLabels = true;
		
		strokeWidthSlider = new JSlider(JSlider.HORIZONTAL, sliderMinWidth, sliderMaxWidth, sliderInitialWidth);
		strokeWidthSlider.setBackground(View.getCanvasBackgroundColor());
		strokeWidthSlider.setMajorTickSpacing(sliderMajorSpacing);
		strokeWidthSlider.setMinorTickSpacing(sliderMinorSpacing);
		strokeWidthSlider.setPaintTicks(sliderShowTicks);
		strokeWidthSlider.setPaintLabels(sliderShowLabels);
		strokeWidthSlider.addChangeListener(this);
		add(strokeWidthSlider);
		
	    setStrokeWidth(sliderInitialWidth); // Set initial stroke width.
		
	    
	    
		// Construct color picker button.
	    colors = new JButton("Choose Color");
	    colors.setBackground(Color.WHITE);
	    colors.addActionListener(this);
	    add(colors);
		
	    
	    
		// Construct outline and fill radio buttons.
		outline = new JRadioButton("   Outline   ");
		outline.setMnemonic(KeyEvent.VK_C);
		outline.setBackground(View.BUTTON_UNSELECTED_BACKGROUND_COLOR);
		outline.addActionListener(this);
		outline.setSelected(true);
		add(outline);
	    
	    fill = new JRadioButton("    Solid    ");
	    fill.setMnemonic(KeyEvent.VK_B);
		fill.setBackground(View.BUTTON_UNSELECTED_BACKGROUND_COLOR);
		fill.addActionListener(this);
	    add(fill);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(fill);
	    group.add(outline);
	}

	private void setStrokeWidth(int width) {
		width = Math.max(width, 1); // width must be positive
		this.strokeWidthSlider.setValue(width);
		this.strokeWidthTf.setText(Integer.toString(width));
		view.getModel().setStrokeWidth(width);
	}
	
	@Override
	public void stateChanged(ChangeEvent changeEvent) {
		JSlider slider = (JSlider) changeEvent.getSource();
		setStrokeWidth(slider.getValue());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Set color.
		if (e.getSource().equals(this.colors)) {
			openColorPicker();
		}

		// Set stroke width.
		try {
			setStrokeWidth(Integer.parseInt(this.strokeWidthTf.getText()));
		} catch(NumberFormatException numberFormatExeception) {
			setStrokeWidth(this.strokeWidthSlider.getValue());
		}
		
		// Set drawing mode to fill or outline.
		if (e.getSource().equals(this.fill)) this.view.getModel().setHasFill(true);
		else if (e.getSource().equals(this.outline)) this.view.getModel().setHasFill(false);
	}
	
	/**
	 * Creates a new ColorPicker for the user to choose colors
	 * for the shapes or for the background.
	 */
	private void openColorPicker() {
		ColorPicker cc1 = new ColorPicker(view);
		cc1.setVisible(true);
		cc1.setSize(400,300);
	}
}
