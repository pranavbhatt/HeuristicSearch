/**
 *
 * (c)Pranav Bhatt, 2013
 * 
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;




/*
* This is Uniform Cost Search Class which performs uniform cost search
* to find optimal path from source node to goal node, using hashmap created by the parser class.
* this class also creates a traversal log of visited nodes.
*  
* */
class Greedy {

	/*
	 * frontier is a FIFO queue
	 */
	LinkedList<NodeInfo> frontier;
	LinkedList<String> explored;
	Node child;
	List<Node> childList;
	NodeInfo childData;
	NodeInfo endTour;
	NodeInfo node;
	File optimal = new File(tsp.outputPath);
	File logFile = new File(tsp.outputLog);

	private void addChildren(List<Node> children, int last) {
		int i = 0;
		
		if(last == 0){
		while (i < children.size()) {
			double gcost = 0.0;
			// child is a node that is removed from the parent's childList
			child = children.get(i);

			if (!(explored.contains(child.name))) {
				
				gcost = child.sld + node.g;
				
				
				childData = new NodeInfo(child.name, node.path, gcost);
				childData.path.add(node.nodeName);				
					frontier.add(childData);
				}
			i++;
		}
		}else{
			
			int j = 0;
			while (j < children.size()) {
				double gcost = 0.0;
				// child is a node that is removed from the parent's childList
				child = children.get(j);
				if(child.name.equals(tsp.initialState)){
					gcost = child.sld + node.g;
					endTour = new NodeInfo(child.name, node.path, gcost);
					endTour.path.add(node.nodeName);
					endTour.path.add(child.name);
					break;
				}
				j++;
			}
			System.out.println("Last Node: "+child.name);
		}
	}

	/*
	 * function UNIFORM-COST-SEARCH(problem) returns a solution, or failure
	 */
	public void search() {

		// creates the file
	    try {
			optimal.createNewFile();
			logFile.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  
	    FileWriter log = null;
	    FileWriter opt = null;
		try {
			opt = new FileWriter(optimal);
			log = new FileWriter(logFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		

		System.out.println("Greedy Search with Straight Line Distance Heuristics \n");

		// a queue of nodes
		frontier = new LinkedList<NodeInfo>();
		explored = new LinkedList<String>();

		node = new NodeInfo(tsp.initialState);

		frontier.add(node);

		while (true) {

			if (frontier.peek() == null) {
				addChildren(childList,1);
				try {
					for (String s : endTour.path) {
						opt.write(s+"\n");
						log.write(s);
					}
					opt.write("Total Tour Cost:"+(endTour.g + endTour.h));
					log.write(","+(endTour.g));
					log.write(","+(endTour.h));
					log.write(","+(endTour.g + endTour.h));

					opt.close();
					log.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}

			node = frontier.remove();
			explored.add(node.nodeName);
			System.out.println("Node visited: "+node.nodeName);
			frontier.clear();
			
			try {
				
				if (!node.nodeName.equals(tsp.initialState)) {
					for (String s : node.path) {
						log.write(s);
					}
					log.write(node.nodeName);
					log.write(","+(node.g));
					log.write(","+(node.h));
					log.write(","+(node.g + node.h));
					log.write("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
			

				childList = tsp.graph.get(node.nodeName);
				addChildren(childList,0);
			
			Compare.sort(frontier);	
		}
	}
}