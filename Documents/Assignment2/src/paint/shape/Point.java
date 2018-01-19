package ca.utoronto.utm.paint.shape;

import java.util.ArrayList;

/**
 * 
 * Represents a Point in 2D space.
 *
 */
public class Point {
	
	double x, y;
	
	public Point(double x, double y){
		this.x=x; 
		this.y=y;
	}
	
	public int getX() {
		return (int)x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return (int)y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	/**
	 * Return a Vector whose tail is at other and tip is at this
	 * @param other		the other Point to be subtracted from this
	 * @return Vector	tail at other, tip at this
	 */
	public Vector subtract(Point other) {
		return new Vector(this.x - other.getX(), this.y - other.getY());
	}
	
	
	/**
	 * Return the tip of Vector other when its tail is at this
	 * @param other	the Vector to be added to this 
	 * @return	Point where Vector other's tip lie 
	 */
	public Point add(Vector other) {
		return new Vector(this.x + other.getX(), this.y + other.getY());
	}
	
	
	/**
	 * This function simply calls getRotatedAndScaledPoints with a radius of 1.
	 */
	public static ArrayList<Point> getRotatedPoints(Point origin, Vector axis, int numberOfPoints) {
		return getRotatedAndScaledPoints(origin, axis, 1, numberOfPoints);
	}
	
	/**
	 * Return an ArrayList<Point> containing numberOfPoints points. All points are
	 * equally spaced along a circle whose radius is radius and center is origin. One
	 * of these points lie on the line defined by the point origin and the vector axis.
	 * 
	 * @param origin			center of the group of points to be returned
	 * @param axis				direction of one of the points to be returned
	 * @param radius			the distance each point is from origin
	 * @param numberOfPoints	number of points to be returned
	 * @returnArrayList<Point>	a set of points spaced equally apart along a circle
	 * 							centered at origin
	 */
	public static ArrayList<Point> getRotatedAndScaledPoints(Point origin, Vector axis, double radius, int numberOfPoints) {
		ArrayList<Vector> rotatedVectors = Vector.getRotatedVectors(axis, radius, numberOfPoints);
		ArrayList<Point> rotatedPoints = new ArrayList<Point>();
		for(Vector vector : rotatedVectors)
			rotatedPoints.add(origin.add(vector));
		return rotatedPoints;
	}
	
}
