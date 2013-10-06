/**
 *
 * (c)Pranav Bhatt, 2013
 * 
 */


/*
 * Node class creates initial nodes parsed from the input and stores their
 * straight line distance from the other node.
 * */
class Node{

	protected String name;
	
	//Distance of the node from the node in the key of HashMap.
	protected double sld = 0;

	public Node(String name,double sld){
		this.name = name;
		this.sld = sld;
	}
}