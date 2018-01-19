package ca.utoronto.utm.paint.manipulatorstrategy;

import ca.utoronto.utm.paint.shape.Circle;
import ca.utoronto.utm.paint.shape.Eraser;
import ca.utoronto.utm.paint.shape.Oval;
import ca.utoronto.utm.paint.shape.Polygon;
import ca.utoronto.utm.paint.shape.Polyline;
import ca.utoronto.utm.paint.shape.Rectangle;
import ca.utoronto.utm.paint.shape.RegularPolygon;
import ca.utoronto.utm.paint.shape.RoundedRectangle;
import ca.utoronto.utm.paint.shape.RoundedSquare;
import ca.utoronto.utm.paint.shape.Square;
import ca.utoronto.utm.paint.shape.Squiggle;
import ca.utoronto.utm.paint.shape.Star;

/**
 * Used to create a manipulator strategy when given a String type.
 *
 */
public class ShapeManipulatorStrategyFactory {
	
	public static ShapeManipulatorStrategy getStrategy(String type) {
		ShapeManipulatorStrategy strategy = null;
		
		if (type == Circle.class.getTypeName()) strategy = new CircleManipulatorStrategy();
		else if (type == Rectangle.class.getTypeName()) strategy = new RectangleManipulatorStrategy();
		else if (type == Square.class.getTypeName()) strategy = new SquareManipulatorStrategy();
		else if (type == Polyline.class.getTypeName()) strategy = new PolylineManipulatorStrategy();
		else if (type == Squiggle.class.getTypeName()) strategy = new SquiggleManipulatorStrategy();
		else if (type == RoundedRectangle.class.getTypeName()) strategy = new RoundedRectangleManipulatorStrategy();
		else if (type == RoundedSquare.class.getTypeName()) strategy = new RoundedSquareManipulatorStrategy();
		else if (type == Oval.class.getTypeName()) strategy = new OvalManipulatorStrategy();
		else if (type == Polygon.class.getTypeName()) strategy = new PolygonManipulatorStrategy();
		else if (type == RegularPolygon.class.getTypeName()) strategy = new RegularPolygonManipulatorStrategy();
		else if (type == Star.class.getTypeName()) strategy = new StarManipulatorStrategy();
		else if (type == Eraser.class.getTypeName()) strategy = new EraserManipulatorStrategy();

		
		return strategy;
	}
	
}
