
/*Stores a point parsed from the input,
 * name: represents the name used to identify the point
 * x represents: x coordinate of the point and 
 * y represents: y coordinate of the point
*/
public class Point {
	protected final String name;
	protected final int x;
	protected final int y;
	
	public Point(String name ,int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
	}
}
