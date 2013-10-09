/**
 *
 * (c)Pranav Bhatt, 2013
 * 
 */
import java.util.*;


/*
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
		
		
		//int i;
		

	//	if(args.length != 10 ){
	//		System.err.println("Invalid number of arguments");
		//	return;
	//	}
		
		
		//	for(i = 0;i < args.length;i++){
				
			//	if(args[i].equals("-t")){
				//	option = Integer.parseInt(args[i+1]);
			//	}else if(args[i].equals("-s")){
					//tsp.initialState = args[i+1];	
					tsp.initialState = "a";	

			//	}else if(args[i].equals("-i")){
					
					/*
					 * Creates a parser object which parses the input file.
					 * 
					 * */
					Parser p = new Parser();
					if(!(p.parseFile("input2.txt"))){
						System.err.println("Give correct Input filename");
						return;
					}
					
					
		//		}else if(args[i].equals("-op")){
			//		tsp.outputPath = args[i+1];
					tsp.outputPath = "output.txt";
					
					
			//	}else if(args[i].equals("-ol")){
				//	tsp.outputLog = args[i+1];
					tsp.outputLog = "log.txt";

		//		}
		//	}
				
					Astar s = new Astar();
					s.search();
		
		if(option == 1){
			
			/*
			 * Creates a BFS object which performs Breadth First Search
			 * 
			 * */
		//	BFS bfs = new BFS();
			//bfs.Bfs();
		}else if( option == 2){
			
			/*
			 * Creates a DFS object which performs Breadth First Search
			 * 
			 * */
			//DFS dfs = new DFS();
			//dfs.Dfs();
		
		}else if(option == 3){
			/*
			 * Creates a Uniform Cost Search object which performs Breadth First Search
			 * 
			 * */
		//	UniformCost u = new UniformCost();
		//	u.Uncs();
		}
		
	}
}