import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Umlaute
public class SentenceTool {


	HashMap<Integer, ArrayList<String>> hm = null;

	// constructor: reads a textfile with given fileName
	// and creates a list of all sentences in this textfile
	public SentenceTool(String fileName) {
		hm = new HashMap<Integer, ArrayList<String>>();

		try {
			BufferedReader in = null;
			try {
				// // abstract base class for representing an input stream of bytes
				InputStream inStream = new FileInputStream(fileName);
				// // using a Reader for input
				Reader r = new InputStreamReader(inStream, StandardCharsets.UTF_8); // for ä,ö, etc

				in = new BufferedReader(r);

				String line = "";
				int linecounter = 0;
				int sentencecounter = 0;
				while (in.ready()) {
					linecounter++;
					line = in.readLine(); // reading next line

					// Now for each loop over all the lines and split them
					// Maybe even use a HashMap for lines, and let string id be the number of the
					// line (counter)
					// and the second argument is a list

					String[] split = line.split("(?<=\\.|\\!|\\?)"); // split by ? ! . and consecutive whitespace
					ArrayList<String> linesentences = new ArrayList<String>(); // empty list for

					// put them all seperated into the sentences list
					for (String sentence : split) {
						String s = sentence.trim(); //remove empty spaces that are unneccessary
						if(s.length() > 0 ) {
							sentencecounter++;
							linesentences.add(s);
						}

					}

					// add the senteces list together with the number of the line to the hashmap
					hm.put(linecounter, linesentences);
				}

//				System.out.println("Total Line Count: " + linecounter);
//				System.out.println("Total Sentence Count: " + sentencecounter);
			

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

	public Set <Integer> lineSet(){
		return hm.keySet();
	}

	 public int size() {
		 int size = 0;
		 for(Integer k: lineSet()) {
			 Iterator<String> it = lineIterator(k);
			 while(it.hasNext()) {
				 it.next();
				 size ++;
			 }
		 }
		 return size;
	 }
	 
	
	public Iterator<Integer> mhIterator() {
		return hm.keySet().iterator();
	}

	public Iterator<String> lineIterator(int line_key) {
		ArrayList<String> sentences_in_line = hm.get(line_key); // gets the arraylist
		// that is associated with the line
		// containing all the sentences in that line
		return sentences_in_line.iterator(); // return iterator for this (ArrayList.iterator())
	}

}
