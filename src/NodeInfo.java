/**
 *
 * (c)Pranav Bhatt, 2013
 * 
 */
import java.util.*;


/*
 * NodeInfo class creates an object for each node, 
 * Storing the node name, pathCost to reach the node, and an arrayList of its ancestors
 *  
 *   */
public class NodeInfo {
	String nodeName;
	ArrayList<String> path = new ArrayList<String>();
	double g;
	double h;
	String parentName;
	
	public NodeInfo(String nodeName, ArrayList<String>path,Double g){
		this.nodeName = nodeName;
		this.g = g;
		for(String s:path){
			this.path.add(s);
		}
		this.h = 0.0;
	}
	
	public NodeInfo(String nodeName){
		this.nodeName = nodeName;
		this.g = 0.0;
		this.h = 0.0;
	}
	
}
