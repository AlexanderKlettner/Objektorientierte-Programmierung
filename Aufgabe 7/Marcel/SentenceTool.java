
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;


//Umlaute
public class SentenceTool {
	ArrayList<String> sentences = null;
	Iterator<String> it = null;

	// constructor: reads a textfile with given fileName
	// and creates a list of all sentences in this textfile
	public SentenceTool(String fileName) {
		ArrayList<String> lines = new ArrayList<String>();
		sentences = new ArrayList<>();
		try {
			BufferedReader in = null;
			try {
				// // abstract base class for representing an input stream of bytes
				InputStream inStream = new FileInputStream("auf7_1.txt");
				// // using a Reader for input
				Reader r = new InputStreamReader(inStream, StandardCharsets.UTF_8); // for ä,ö, etc

				in = new BufferedReader(r);

				// String line = "";

				while (in.ready()) {
					// line = in.readLine(); // reading next line
					lines.add(in.readLine()); // Add line to the lines Array
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

		// Combine strings to one big string, having the line number in front of each
		// sentence:
		String combinedSentencesInLine = "";
		for (int i = 0; i < lines.size(); i++) {
			// fetch the line
			String line = lines.get(i);
			// split line into all the sentences it contains
			String[] sentences_line = line.split("(?<=\\.)|(?<=\\?)|(?<=\\!)");

			// Empty String for combining the sentences
			String currentSentence = "";
			int lineInteger = i + 1; // number of the line
			// Add the line number in front of each sentence
			for (int j = 0; j < sentences_line.length; j++) {
				if (sentences_line[j].trim().length() > 0) { // only save into array if the line has something in it
					// delete leading white space:
					currentSentence = sentences_line[j];
					if (currentSentence.substring(0, 1).equals(" ")) { // if first character of string is empty
						// delete first character of string
						currentSentence = currentSentence.substring(1, currentSentence.length());
					}
					combinedSentencesInLine += "[" + lineInteger + "]" + currentSentence; // concatenate into big string
				}

			}

		}

		// Split them up again and save in arraylist, so we have all the sentences with
		// an [i] in front of them
		// i ... indexing the line, the sentence came from
		String[] split = combinedSentencesInLine.split("(?<=\\.)|(?<=\\?)|(?<=\\!)");
		// ?<=\\. : Splits at "." and keeps the delimiter

		// add them to the arraylist, that we later iterate over
		for (String s : split) {
			sentences.add(s);
		}
		
		it = getIterator();

	}

	public int size() {
		return sentences.size();
	}

	public Iterator<String> getIterator() {
		return sentences.iterator();
	}
	
	  //returns the next sentence
	  //returns null if there is no more sentence
	public String nextSentence() {
		if(it.hasNext()) return it.next();
		else return null;
	}
	//test if there exists a next sentence
	public boolean hasNextSentence(){
		return it.hasNext();
	}
}
