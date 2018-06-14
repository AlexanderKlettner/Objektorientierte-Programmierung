import java.io.*;
import java.util.*;

public class SentenceTool {

	ArrayList<String> list = null;

	// constructor: reads a textfile with given fileName
	// and creates a list of all sentences in this textfile
	public SentenceTool(String fileName) {
		list = new ArrayList<String>();
		try {
			BufferedReader in = null;
			try {
				// abstract base class for representing an input stream of bytes
				InputStream inStream = new FileInputStream(fileName);
				// using a Reader for input
				Reader r = new InputStreamReader(inStream);
				// additional buffer and methods for efficient input
				in = new BufferedReader(r);

				String line;
				while (in.ready()) {
					line = in.readLine(); // reading next line
					list.add(line);
				}
			} catch (Exception e) {
				System.out.println(">> Exception 1: " + e.getMessage());
			}
			// these instructions are always executed
			finally {
				if (in != null)
					in.close();
				// System.out.println("All closed");
			}
		} catch (Exception e) {
			System.out.println(">> Exception 2: " + e.getMessage());
		}
	}
	
	public String toString() {
		return list.toString();
	}

	// returns the number of sentences in this sentence list
	 public int size() {
		 return list.size();
	 }

	// returns the next sentence
	// returns null if there is no more sentence
	 public String nextSentence() {
		 if(hasNextSentence()) {
			 return list.remove(0);
		 }else return null;
	 }

	// test if there exists a next sentence
	 public boolean hasNextSentence() {
		 return list.size() > 0;
	 }

}
