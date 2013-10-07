/**
 *
 * (c)Pranav Bhatt, 2013
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
}