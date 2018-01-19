package ca.utoronto.utm.paint.manipulatorstrategy;

/**
 * Stores data used for drawing shapes.
 *
 */
public class ShapeManipulatorData {
	private static int numberOfSides = 5;
	
	public static void setNumberOfSides(int numberOfSides) {
		ShapeManipulatorData.numberOfSides = numberOfSides;
	}
	
	public static int getNumberofSides() {
		return ShapeManipulatorData.numberOfSides;
	}
}
