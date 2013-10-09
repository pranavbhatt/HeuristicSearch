/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.io.*;
import java.util.*;


/**
 * This class takes the input file passed by the tsp class.
 * For each line in the input parser creates a point represented by its name ,x coordinate and y coordinate
 * and adds the point to a list of type <Point> called points.
 * It then calls the createMap function which creates a hashMap for the problem and stores it in the static variable graph.
 * graph maps each node(key: string) to a list of Nodes in which each node contains Straight Line distance from the key.
 * 
 */
class Parser{

	/**
	 * Path of the file to be opened
	 */
	private String FilePath;
	
	
	
	
	List<Node> value =null;
	List<Point> points = new ArrayList<Point>();
	
	/** 
	 *	This method takes filename as an input 
	 * and parses file line by line
	 *
	 */
	public boolean parseFile(String path){


		
		String[] str = null;
		FilePath = path;
		
		try{
			
			FileReader file = new FileReader(FilePath);
			Scanner scanner = new Scanner(file);														
			
			while(scanner.hasNextLine()){

				String line = scanner.nextLine();
				str = line.split(",");
				
				
				Point p = new Point(str[0],Double.parseDouble(str[1]),Double.parseDouble(str[2]));
				
				//adding the point to the list of points
				points.add(p);
			}
			
			tsp.numNodes = points.size();
			scanner.close();
			createMap(points);
			}catch(IOException e){
				
				return false;
				
			}
		
		
		return true;
	}
	
	public void createMap(List<Point> list){
		
		double sdistance = 0;
		
		for(Point p:list){
			
			for(Point q:list){
				
				/**
				 *  repeat for each point in the graph except for itself.
				 * */
				if(!p.name.equals(q.name)){
					
					/**
					 * calculating straight line distance between the points
					 * */
					sdistance = Math.sqrt(Math.pow(p.x - q.x, 2.0) + Math.pow(p.y - q.y, 2.0));
					
					//creating a node which is adjacent to current node p
					Node n = new Node(q.name,sdistance);
					
					value = tsp.graph.get(p.name);
					
					/**
					 * checking if key has already been created in the hashMap or not
					 * */
					if (value == null){
						value = new ArrayList<Node>();
						value.add(n);
						tsp.graph.put(p.name,value);
					}else{
						value.add(n);
					}
					}
				}
			
			/*
			System.out.println(" \nParent Name: "+p.name);
			value2 = tsp.graph.get(p.name);
			for(Node n:value2){
				System.out.println("Child Name: "+n.name);
				System.out.println("Child SLD: "+n.sld);
			
				
			}*/
			
			}
		}
	}