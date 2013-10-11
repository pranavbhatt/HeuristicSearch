import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author pranavbhatt (c) 2013
 *  This is a class which writes Logs and Outputs for various search algorithms.
 * 
 */


public class LOWriter {
	
	
	private static File optimal = new File(tsp.outputPath);
	private static File logFile = new File(tsp.outputLog);
	private static FileWriter log = null;
	private static FileWriter opt = null;

	/**
	 * init is a static function of LOWriter class
	 * It initializes output file called optimal which contains the optimal tour,
	 * log file which contains the traverse log
	 * it also creates two FileWriter objects
	 *  opt and log: for writing to corresponding files.
	 * 
	 */
	
	protected static void init() {

		// creates the file
		try {
			optimal.createNewFile();
			logFile.createNewFile();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			opt = new FileWriter(optimal);
			log = new FileWriter(logFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	

	/** 
	 * @param endTour: an object of type NodeInfo containing 
	 * final path to goal node, optimal path cost(g), 
	 * heuristics cost(h) from the current node to goal node(0.0) and total cost(f)
	 */
	protected static void output(NodeInfo endTour) {

		try {
			for (String s : endTour.path) {
				opt.write(s + "\n");
				log.write(s);
			}
			
			/**
			 * Writing the optimal tour to the log file
			 */
			log.write("," + (endTour.g));
			log.write("," + (endTour.h));
			log.write("," + (endTour.f));
			
			/**
			 * Generating the output file by writing the optimal tour.
			 */
			opt.write("Total Tour Cost:" + (endTour.f));


			opt.close();
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method takes in an Object of type NodeInfo and 
	 * writes into the log file, path to the node,
	 * path cost, heuristics cost and total cost 
	 * @param node: an object of type NodeInfo containing 
	 * path, path cost(g), heuristics cost(h) and total cost(f)
	 */
	protected static void log(NodeInfo node) {

		try {
			for (String s : node.path) {
				log.write(s);
			}
			log.write(node.nodeName);
			log.write("," + (node.g));
			log.write("," + (node.h));
			log.write("," + (node.f));
			log.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
