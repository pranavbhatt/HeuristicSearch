/**
 *
 *@author pranavbhatt (c) 2013
 * 
 * Point Class Stores a point parsed from the input,
 * name: represents the name used to identify the point
 * x represents: x coordinate of the point and 
 * y represents: y coordinate of the point
 */
public class Point {
	protected final String name;
	protected  double x;
	protected  double y;
	
	
	public Point(String name ,double x, double y){
		this.name = name;
		this.x = x;
		this.y = y;
	}
}
