/**
 *
 * (c)Pranav Bhatt, 2013
 * 
 */
import java.io.File;
import java.util.*;

/*
 * This is A* Search Class which performs A* search
 * to find optimal path from source node to goal node, using hashmap created by the parser class.
 * this class also creates a traversal log of visited nodes.
 * 
 *  
 * */

class Astar {

	/**
	 * frontier is a FIFO queue
	 */
	LinkedList<NodeInfo> frontier, sortQ;
	Node child;
	List<Node> childList;
	NodeInfo childData, endTour;
	NodeInfo node;
	ArrayList<String> optimalPath = new ArrayList<String>();
	Double gcost, hcost;
	File optimal = new File(tsp.outputPath);
	File logFile = new File(tsp.outputLog);

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
				// child is a node that is removed from the parent's childList
				child = children.get(i);

				if (!(node.path.contains(child.name))) {

					gcost = child.sld + node.g;
					hcost = heuristicCost(child.name);
					
					/**
					 *  getting the ancestorList of parent and putting it in the child
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
				// child is a node that is removed from the parent's childList
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

		// log.writeln("Breadth First Search");

		// a queue of nodes
		frontier = new LinkedList<NodeInfo>(); // Linkedlist frontier
		node = new NodeInfo(tsp.initialState); // initial node

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