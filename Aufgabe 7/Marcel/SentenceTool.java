import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
//Umlaute
public class SentenceTool {

	ArrayList<String> list = null;
	Iterator<String> it = null;

	// constructor: reads a textfile with given fileName
	// and creates a list of all sentences in this textfile
	public SentenceTool(String fileName) {
		list = new ArrayList<String>();
		try {
			BufferedReader in = null;
			try {
//				// abstract base class for representing an input stream of bytes
				InputStream inStream = new FileInputStream(fileName);
//				// using a Reader for input
				Reader r = new InputStreamReader(inStream, StandardCharsets.UTF_8); // for ä,ö, etc
//				Reader r = new InputStreamReader(inStream); // for ä,ö, etc
					
//				Reader r = new InputStreamReader(inStream, "UTF-8");
//				// additional buffer and methods for efficient input
				in = new BufferedReader(r);

			
				String line;
				while (in.ready()) {
					line = in.readLine(); // reading next line
//					System.out.println("Satz vor dem split: " + line);
					//Split them by ".", "!" and "?"
//					String [] split = line.split("(?<=\\.|\\!|\\?)");
				
					String [] split = line.split("(?<=\\. |\\! |\\? )"); // and consecutive whitespace
					for(String sentence: split) {
						list.add(sentence);	
						System.out.println(sentence);
					}
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
		it = this.getIterator();
	}
	
	public String toString() {
		return list.toString();
	}

	// returns the number of sentences in this sentence list
	 public int size() {
		 return list.size();
	 }

	 public Iterator<String> getIterator(){
		 Iterator<String> it = list.iterator();
		 return it;
	 }
	// returns the next sentence
	// returns null if there is no more sentence
	 public String nextSentence() {
		 // old
//		 if(hasNextSentence()) {
//			 return list.remove(0);
//		 }else return null;
		 
		 // new:
		 if(hasNextSentence()) {
			 return it.next();
		 }else return null;
		  
		 
	 }

	// test if there exists a next sentence
	 public boolean hasNextSentence() {
		// old
		// return list.size() > 0;
		 
		 
		// new:
		 return it.hasNext();
	 }
	
}
