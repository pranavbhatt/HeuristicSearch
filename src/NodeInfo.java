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
	Double pathCost;
	String parentName;
	
	public NodeInfo(String nodeName, ArrayList<String>path,Double pathCost){
		this.nodeName = nodeName;
		this.pathCost = pathCost;
		for(String s:path){
			this.path.add(s);
		}
	}
	
	public NodeInfo(String nodeName){
		this.nodeName = nodeName;
		this.pathCost = 0.0;
	}
	
}
