/**
 *
 *@author pranavbhatt (c) 2013
 * 
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


/*
 * Compare class object will be used to sort a LinkedList of NodeInfo object 
 * based on the pathCost stored in each Node. 
 *  
 * */
class Compare implements Comparator<NodeInfo>{
	
	
	
	@Override
    public int compare(NodeInfo n1, NodeInfo n2){
		return 0;
    }
	
	public static void sort(LinkedList<NodeInfo> List) {
	    Collections.sort(List, new Compare() {
	        @Override
	        public int compare(NodeInfo o1, NodeInfo o2) {
	        return Double.valueOf(o1.g).compareTo(o2.g);
	        }
	    });
	}

	/**
	 * Sorts the LinkedList of NodeInfo objects based on the total cost
	 * total cost f
	 * @param List is a linked list of type NodeInfo
	 */
	public static void sortT(LinkedList<NodeInfo> List) {
	    Collections.sort(List, new Compare() {
	        @Override
	        public int compare(NodeInfo o1, NodeInfo o2) {
	        return Double.valueOf(o1.f).compareTo(o2.f);
	        }
	    });
	}
}