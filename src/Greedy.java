/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This is Greedy Search Class which performs greedy search,
 * to find optimal path from source node to goal node, using Straight Line Distance Heuristics, 
 * on a Graph represented by a HashMap(tsp.graph) created by the parser class.
 * */
class Greedy {

	/**
	 * frontier is a FIFO priority queue
	 * explored is a LinkedList of explored Nodes in the graph
	 * child is a node that is removed from the parent's childList
	 * childList is a list of nodes that a parent is connected to.
	 * Endtour is the tour from the the last visited node back to the source node which is also the goal node
	 * 
	 */
	
	
	PriorityQueue<NodeInfo> frontier = new PriorityQueue<NodeInfo>(1,new Compare() {
        @Override
        public int compare(NodeInfo o1, NodeInfo o2) {
        return Double.valueOf(o1.g).compareTo(o2.g);
        }
    });
	
	//LinkedList<NodeInfo> frontier;
	LinkedList<String> explored;
	Node child;
	List<Node> childList;
	NodeInfo childData;
	NodeInfo endTour;
	NodeInfo node;
	

	private void addChildren(List<Node> children, boolean last) {
		int i = 0;

		if (last == false) {
			while (i < children.size()) {
				double gcost = 0.0;
				
				child = children.get(i);

				if (!(explored.contains(child.name))) {
					gcost = child.sld + node.g;
					childData = new NodeInfo(child.name, node.path, gcost);
					childData.path.add(node.nodeName);
					childData.f = childData.g + childData.h;
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

	/**
	 * function search returns a solution(output and traverse log), or failure
	 */
	public void search() {

		LOWriter.init();

		System.out.println("Greedy Search with Straight Line Distance Heuristics \n");

		// a queue of nodes
	//	frontier = new LinkedList<NodeInfo>();
		explored = new LinkedList<String>();

		node = new NodeInfo(tsp.initialState);

		frontier.add(node);

		while (true) {

			if (frontier.peek() == null) {
				addChildren(childList, true);
				LOWriter.output(endTour);
				return;
			}

			node = frontier.remove();
			explored.add(node.nodeName);
			frontier.clear();

			if (!node.nodeName.equals(tsp.initialState)) {
				LOWriter.log(node);
			}

			childList = tsp.graph.get(node.nodeName);
			addChildren(childList, false);

		//	Compare.sort(frontier);
		}
	}
}