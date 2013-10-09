import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author pranavbhatt This is a class which writes Logs and Outputs for various
 *         searches.
 * 
 */
public class LOWriter {

	private static File optimal = new File(tsp.outputPath);
	private static File logFile = new File(tsp.outputLog);
	private static FileWriter log = null;
	private static FileWriter opt = null;

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

	protected static void output(NodeInfo endTour) {

		try {
			for (String s : endTour.path) {
				opt.write(s + "\n");
				log.write(s);
			}
			log.write("," + (endTour.g));
			log.write("," + (endTour.h));
			log.write("," + (endTour.f));
			opt.write("Total Tour Cost:" + (endTour.f));


			opt.close();
			log.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

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
