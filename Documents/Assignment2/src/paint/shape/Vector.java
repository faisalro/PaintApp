package ca.utoronto.utm.paint.shape;

import java.util.ArrayList;

/**
 * 
 * Represents a Vector with its tail at the origin and tip at the point (x, y).
 *
 */
public class Vector extends Point {
	
	public Vector(double x, double y) {
		super(x, y);
	}
	
	public Vector scale(double factor) {
		return new Vector(this.x * factor, this.y * factor);
	}
	
	public Vector add(Vector other) {
		return new Vector(this.x + other.x, this.y + other.y);
	}
	
	public Vector subtract(Vector other) {
		return new Vector(this.x - other.x, this.y - other.y);
	}
	
	/**
	 * Get the magnitude of this.
	 * @return double	the magnitude of this
	 */
	public double getMagnitude() {
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Get the unit vector whose direction is the same as this.
	 * @return Vector	a unit vector in the same direction as this
	 */
	public Vector getUnitVector() {
		return new Vector(x / getMagnitude(), y / getMagnitude());
	}
	
	/**
	 * Get the vector with the same magnitude as this but whose direction
	 * is rotated theta radians counterclockwise.
	 * @param theta		angle in radians
	 * @return Vector	this vector rotated by theta radians counterclockwise.
	 */
	public Vector rotate(double theta) {
		double x1 = this.x*Math.cos(theta) - this.y*Math.sin(theta);
		double y1 = this.x*Math.sin(theta) + this.y*Math.cos(theta);
		return new Vector(x1, y1);
	}
	
	/**
	 * 
	 * Returns an ArrayList<Vector> with numberOfVectors elements. Each vector has a length of magnitude.
	 * The angle between any two consecutive vectors are the same and those angles add up to 2*pi radians.
	 * One such vector has the same direction as axis with a length of magnitude.
	 * 
	 * @param axis				the axis where the the angle is said to be 0
	 * @param magnitude 		the length of the vectors
	 * @param numberOfVectors	the number of vectors to be returned
	 * @return ArrayList<Vector>
	 * 
	 */
	public static ArrayList<Vector> getRotatedVectors(Vector axis, double magnitude, int numberOfVectors) {		
		ArrayList<Vector> vectors = new ArrayList<Vector>();
		Vector vector = axis.getUnitVector();
		vectors.add(vector.scale(magnitude));
		double theta = 2 * Math.PI / numberOfVectors;
		
		for(int i = 0; i < numberOfVectors - 1; i++) {
			vector = vector.rotate(theta);
			vectors.add(vector.scale(magnitude));
		}
		return vectors;
	}
	
}
