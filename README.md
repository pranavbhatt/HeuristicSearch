HeuristicSearch
===============
Greedy and A* Search Algorithms for Euclidean Travelling Salesman Problem with two heuristics:  straight line distance and  minimum spanning tree.

Problem Description
====================
	1. The version of TSP I am solving is defined as follows: 
 	2. Given a set of cities and distances between every pair of cities, and starting from a particular city, find the shortest way of visiting all the cities exactly once and returning to the starting city. 
 	3. We can imagine the cities as nodes in a completely connected graph, and distances as the edge cost between the nodes representing cities. Now the TSP problem is transformed to finding the shortest tour of the graph. 
 	4. TSP is a well known NP-Complete problem. 
 	5. We only have a list of cities with their coordinates is given as input.
 	6. Thus, we need to construct a graph by yourself. An image below shows how to construct a graph from a city list. (Refer Figure 1 (a) and (b)
 	7. In Figure1 : There are 6 edges in this example. For simplicity, let us assume that weight of each edge is given by the length of the straight line between the corresponding cities. Assume that p and q are cities, with the location of p= (p1,p2) and location of q = (q1,q2). 
 	8. The weight of the edge between p and q can be computed by 
	9. For example, a straight line between a = (0,1) and d= (1,0) is 1.414 .An example of desired output is shown in the figure 2. 

Solution
=========
	I have written a program to implement the following search algorithms. 
		1. Find a tour using Greedy search 
 		2. Find the optimal tour with A* search using straight line distance as a heuristic 
 		3. Find the optimal tour with A* search using minimum spanning tree as a heuristic 


Execution
==========
This program is written in java.

 	1.To compile:
		change directoty to source.
		javac *.java

	2. To Run the Code:
		java tsp -t <task> -s <start_node> -i <input_file> -op <output_path> -ol <output_log> 
