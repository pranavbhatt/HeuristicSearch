/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.util.*;

/**
 * This is A* Search Class which performs A* search
 * to find optimal tour of the graph, using Straight Line Distance Heuristics on a HashMap created by the parser class.
 * this class also creates a traversal log of visited nodes.
 * 
 *  
 * */

class Astar {

	int count = 0;
	/**
	 * frontier is a FIFO queue
	 * child is a node that is removed from the parent's childList
	 * childList is a list of nodes that a parent is connected to.
	 * endtour is the tour from the the last visited node back to the source node which is also the goal node
	 * 
	 */
	LinkedList<NodeInfo> frontier;
	Node child;
	List<Node> childList;
	NodeInfo childData, endTour;
	NodeInfo node;
	Double gcost, hcost;
	

	/**
	 * heuristicCost takes in a string value child, and finds its straight line
	 * distance from the goal node
	 * 
	 * @param child : a variable of type String which represents a child name.
	 * @return: returns the straight line distance of child from the goal node
	 */
	private double heuristicCost(String child) {
		
		double h = 0.0;
		for (Node c : tsp.graph.get(tsp.initialState)) {
			if (c.name.equals(child)) {
				h = c.sld;
				break;
			}
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
					
					hcost = heuristicCost(child.name);

					/**
					 * getting the ancestorList of parent and putting it in the
					 * child
					 */

					childData = new NodeInfo(child.name, node.path, gcost,
							hcost);
					childData.path.add(node.nodeName);
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

		frontier = new LinkedList<NodeInfo>(); 
		node = new NodeInfo(tsp.initialState); 

		frontier.add(node);

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