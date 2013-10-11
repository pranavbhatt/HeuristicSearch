/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.util.*;


/**
 * This is the main class which reads the command line instructions and stores some information in
 * relevant static variables which are used in other classes
 * and passes the filename to the parser class method ParseFile.
 * It receives the hashmap stored in static variable problem.
 * It calls appropriate methods of BFS,DFS,UniformCost and ReliabilityCost classes
 *  to perform various tasks as per input.
 * 
 * */
class tsp{
	protected static int numNodes;
	protected static String initialState;
	protected static HashMap<String, List<Node>> graph = new HashMap<String, List<Node>>();
	protected static int option;
	protected static String outputPath,outputLog;
	public static void main(String[] args) {
		
		
		int i;
		

		if(args.length != 10 ){
			System.err.println("Invalid number of arguments");
			return;
		}
		
		
			for(i = 0;i < args.length;i++){
				
				if(args[i].equals("-t")){
					option = Integer.parseInt(args[i+1]);
				}else if(args[i].equals("-s")){
					tsp.initialState = args[i+1];	
					tsp.initialState = "a";	

				}else if(args[i].equals("-i")){
					
					/*
					 * Creates a parser object which parses the input file.
					 * 
					 * */
					Parser p = new Parser();
					if(!(p.parseFile(args[i+1]))){
						System.err.println("Give correct Input filename");
						return;
					}
					
					
				}else if(args[i].equals("-op")){
					tsp.outputPath = args[i+1];
					
					
				}else if(args[i].equals("-ol")){
					tsp.outputLog = args[i+1];

				}
			}
				
					mAstar s = new mAstar();
					s.search();
		
		if(option == 1){
			
			/*
			 * Creates a BFS object which performs Breadth First Search
			 * 
			 * */
			Greedy g = new Greedy();
			g.search();
			System.out.println("Completed Greedy Search on the input");
		}else if( option == 2){
			
			Astar a = new Astar();
			a.search();
			System.out.println("Completed A* Search with SLD heuristics on the input");

		
		}else if(option == 3){
			/*
			 * Creates a Uniform Cost Search object which performs Breadth First Search
			 * 
			 * */
			mAstar m = new mAstar();
			m.search();
			System.out.println("Completed A* Search with MST heuristics on the input");

		}
		
	}
}