package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * This is the top level View+Controller, it contains other aspects of the
 * View+Controller.
 * 
 * @author JMen
 *
 */
public class View extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	public static final Color PANEL_BACKGROUND_COLOR = Color.CYAN.darker();
	public static final Color BUTTON_UNSELECTED_BACKGROUND_COLOR = Color.CYAN;
	public static final Color BUTTON_SELECTED_BACKGROUND_COLOR = Color.LIGHT_GRAY;
	private static Color CANVAS_BACKGROUND_COLOR = Color.WHITE;
	
	public static Color getCanvasBackgroundColor() {
		return CANVAS_BACKGROUND_COLOR;
	}
	
	public static void setCanvasBackgroundColor(Color color) {
		CANVAS_BACKGROUND_COLOR = color;
	}
	
	private PaintModel model;
	private PaintPanel paintPanel;
	
	private Container northPanel;
	private QuadrilateralPanel quadrilateralPanel;
	private EllipsePanel ellipsePanel;
	private LinePanel linePanel;
	private PolygonPanel polygonPanel;

	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.model = model;
		this.paintPanel = new PaintPanel(model, this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c = this.getContentPane();
		c.add(this.paintPanel, BorderLayout.CENTER);
		c.add(new DrawStylePanel(this), BorderLayout.SOUTH);
		
		
		// Construct mainPanel
		JPanel mainPanel = new JPanel(); mainPanel.setLayout(new GridLayout(1,1));
		JPanel sidePanel = new JPanel(); sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		
		this.northPanel = new JPanel(new CardLayout());
		ShapeChooserPanel shapeChooserPanel = new ShapeChooserPanel(this);
		
		sidePanel.add(this.northPanel, BorderLayout.NORTH);
		mainPanel.add(shapeChooserPanel, BorderLayout.WEST);
		mainPanel.add(sidePanel, BorderLayout.EAST);
		c.add(mainPanel, BorderLayout.WEST);
		
		
		
		// Add to northPanel		
		JPanel emptyPanel = new JPanel(); emptyPanel.setBackground(PANEL_BACKGROUND_COLOR);
		quadrilateralPanel = new QuadrilateralPanel(this);
		linePanel = new LinePanel(this);
		polygonPanel = new PolygonPanel(this);
		ellipsePanel = new EllipsePanel(this);
		this.northPanel.add(emptyPanel); // On startup, we want this panel to be empty.
		this.northPanel.add(linePanel, LinePanel.class.getTypeName());
		this.northPanel.add(quadrilateralPanel, QuadrilateralPanel.class.getTypeName());
		this.northPanel.add(polygonPanel, PolygonPanel.class.getTypeName());
		this.northPanel.add(ellipsePanel, EllipsePanel.class.getTypeName());

		
		this.pack();
		this.setSize(900,490);
		this.setLocation(600, 300);
		this.setVisible(true);
	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}
	
	public PaintModel getModel () {
		return model;
	}
	
	
	public void changeShapePanel(String shape) {
		// Changes button colors back to unselected color.
		this.ellipsePanel.resetButtons();
		this.quadrilateralPanel.resetButtons();
		this.polygonPanel.resetButtons();
		this.linePanel.resetButtons();
		
		CardLayout cl = (CardLayout)(northPanel.getLayout());
		cl.show(northPanel, shape);
	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu("File");

		// a group of JMenuItems
		
		String[] File = {"New", "Open", "Save"};
		
		for (String item: File) {
			menuItem = new JMenuItem(item);
			menuItem.addActionListener(this);
			menu.add(menuItem);
		}
		
		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");
		
		String[] Edit = {"Cut", "Copy", "Paste"};
		
		for (String item: Edit) {
			menuItem = new JMenuItem(item);
			menuItem.addActionListener(this);
			menu.add(menuItem);
		}
		
		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);
		
		return menuBar;
	}
	
	private void newPaint() {
		Paint.main(new String[0]);
		this.dispose();
	}
	
	/**
	 * Controller aspect of this
	 */
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();

		if (action == "Undo") this.model.undo();
		else if (action == "Redo") this.model.redo();
		
		if (action == "New") {
			newPaint();
		}
		if (action == "Exit") {System.exit(0);}
		
		model.modelChanged();
	}
}
