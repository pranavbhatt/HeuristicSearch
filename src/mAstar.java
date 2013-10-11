/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.util.*;

/**
 * This is A* Search Class which performs A* search
 * to find optimal tour of the graph, using Minimum Spanning Tree Heuristics on a HashMap created by the parser class.
 * this class also creates a traversal log of visited nodes.
 * 
 *  
 * */

class mAstar {

	int count = 0;

	/**
	 * frontier is a FIFO queue
	 * explored is a LinkedList of explored Nodes in the graph
	 * current is a LinkedList of current visited nodes,which we have to look through to find the minimum edge
	 * child is a node that is removed from the parent's childList
	 * childList is a list of nodes that a parent is connected to.
	 * Endtour is the tour from the the last visited node back to the source node which is also the goal node
	 * 
	 */
	LinkedList<NodeInfo> frontier;
	Node child;
	List<Node> childList;
	NodeInfo childData, endTour;
	NodeInfo node;
	double gcost, hcost;
	List<String> explored = new ArrayList<String>();
	List<String> current = new ArrayList<String>();

	/**
	 * mheuristicCost takes in a NodeInfo object child, and finds its Minimum Spanning Tree Heuristics Cost
	 * 
	 * @param child: a variable of type NodeInfo which represents a child object, having a name ancestor list and SLD cost from parent.
	 * @return: returns the straight line distance of child from the goal node
	 */
	
	private double mheuristicCost(NodeInfo child) {
		double h = 0.0;
		explored.clear();
		current.clear();
		List<Node> pNodes;
		double min = 0.0;
		String minNode = null;
		
		for(String s: child.path){
			if(!s.equals(tsp.initialState)){
				explored.add(s);
			}
		}
		
		current.add(child.nodeName);
		explored.add(child.nodeName);
		
		
		while(explored.size() <= (tsp.numNodes - 1)){
			
			/**
			 * Iterating over current nodes
			 */
			min = 99999999.99999;
			for(String s:current){
				pNodes = tsp.graph.get(s);
				for(Node p: pNodes){
					if(!explored.contains(p.name)){
						if(p.sld < min){
							min = p.sld;
							minNode = p.name;
						}
					}
					
				}
				
			}
			
			/**
			 * Adding the currently extracted min node to the queue current
			 */
			
			explored.add(minNode);
			current.add(minNode);
			h += min;
		}
		
		return h;
	}

	private void addChildren(List<Node> children, boolean last) {
		int i = 0;
		if (last == false) {
			while (i < children.size()) {

				child = children.get(i);


				if (!(node.path.contains(child.name))) {


					gcost = child.sld + node.g;
					hcost = 0.0;
					
					
					/**
					 * getting the ancestorList of parent and putting it in the
					 * child
					 */
					
					childData = new NodeInfo(child.name, node.path, gcost,hcost);
					childData.path.add(node.nodeName);
					
					/**
					 * getting the Minimum Spanning Tree heuristics Cost, and adding the cost to the childData object
					 */
					hcost = mheuristicCost(childData);
					childData.h = hcost;
					childData.f = gcost + hcost;
					frontier.add(childData);
				}
				i++;
			}
		} else {

			int j = 0;
			while (j < children.size()) {
				double gcost = 0.0;
				child = children.get(j);
				if (child.name.equals(tsp.initialState)) {
					gcost = child.sld + node.g;
					endTour = new NodeInfo(child.name, node.path, gcost);
					endTour.path.add(node.nodeName);
					endTour.path.add(child.name);
					endTour.f = endTour.g + endTour.h;
					break;
				}
				j++;
			}
		}
	}

	public void search() {

		LOWriter.init();


		/**
		 * frontier a queue of nodes
		 */
		frontier = new LinkedList<NodeInfo>(); 
		node = new NodeInfo(tsp.initialState); 

		frontier.add(node);
		node.h = mheuristicCost(node);
		node.f = node.g + node.h;


		while (true) {

			Compare.sortT(frontier);

			if (frontier.peek() == null) {
				return;
			}

			/**
			 * Removing the front of the queue frontier
			 */
			node = frontier.remove();
			

			if (node.path.size() == (tsp.numNodes - 1)) {

				/**
				 * Adding the node to the log
				 */
				LOWriter.log(node);

				childList = tsp.graph.get(node.nodeName);
				addChildren(childList, true);
				/**
				 * Writing the optimal path in the log as well as output file.
				 */

				LOWriter.output(endTour);
				return;
			} else {
				
				LOWriter.log(node);
			}

			childList = tsp.graph.get(node.nodeName);
			addChildren(childList, false);

		}

	}
}