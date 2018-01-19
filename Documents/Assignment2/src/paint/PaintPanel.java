package ca.utoronto.utm.paint;

import javax.swing.*;

import ca.utoronto.utm.paint.manipulatorstrategy.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;
import java.util.Observer;


class PaintPanel extends JPanel implements Observer, MouseMotionListener, MouseListener, ActionListener  {
	private PaintModel model;	
	private ShapeManipulatorContext context;
	private View view;
	
	public PaintPanel(PaintModel model, View view){
		this.setBackground(View.getCanvasBackgroundColor());
		this.setPreferredSize(new Dimension(300,300));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.model = model;
		this.view = view;
		this.model.addObserver(this);
		
		this.context = new ShapeManipulatorContext(model); // This context comes from the "mode" package.
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; 
		this.model.draw(g2d);	
		g2d.dispose();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this
	 */
	
	// Replaces setMode.
	@Override
	public void actionPerformed(ActionEvent e) {
		String type = e.getActionCommand();
		view.changeShapePanel(type);
		ShapeManipulatorStrategy strategy = ShapeManipulatorStrategyFactory.getStrategy(type);
		this.context.changeStrategy(strategy);
		this.view.getModel().modelChanged();
	}
	
	// MouseMotionListener below
	@Override
	public void mouseMoved(MouseEvent e) {
		this.context.mouseMoved(e);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		this.context.mouseDragged(e);
	}

	// MouseListener below
	@Override
	public void mouseClicked(MouseEvent e) {
		this.context.mouseClicked(e);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.context.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.context.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.context.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.context.mouseExited(e);
	}
	
	
}
