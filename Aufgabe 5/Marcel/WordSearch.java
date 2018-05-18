import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
	public static String search(String inFileName, String word) throws FileNotFoundException, IOException {

		// append the "word" thing

		String[] nameParts = inFileName.split("\\.");
		String suffix = nameParts[nameParts.length - 1];
		String rest = "";

		for (int i = 0; i < nameParts.length - 1; i++) {
			rest = rest + nameParts[i];
		}

		String outFileName = rest + "_" + word + "." + suffix;

		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			// abstract base class for representing an input stream of bytes
			InputStream inStream = new FileInputStream(inFileName);
			// using a Reader for input
			Reader r = new InputStreamReader(inStream);
			// additional buffer and methods for efficient input
			in = new BufferedReader(r);

			// abstract base class for representing an output stream of bytes
			OutputStream outStream = new FileOutputStream(outFileName);
			// using a Writer for output
			Writer w = new OutputStreamWriter(outStream);
			// additional buffer efficient output
			out = new BufferedWriter(w);

			
			//Erste Zeile im Outputfile
			out.write("Zeilen mit dem Wort: " + word);

			// Preparation for matching Strings
			String match = "\\b" + word + "\\b"; // Matches a word boundary where a word character is [a-zA-Z0-9_]
			// Findet "Wort" allerdings nicht in String "Wort9"!
			Pattern pattern = Pattern.compile(match);

			// line Variable, that gets the current line of the readin file
			String line;
			int lineNumber = 0;
			boolean foundNothing = true;
			while (in.ready()) {
				lineNumber++;
				line = in.readLine(); // reading next line
				// Checking if line contains the word
				Matcher m = pattern.matcher(line);

				if (m.find() == true) {
					foundNothing = false;
					//Wenn Wort vorkam, dann schreibe die Zeile
					String writeMe = "\n" + lineNumber + ": " + line;
					out.write(writeMe); // write the index and the sentence that contained the word
				}

			}
			System.out.println("Output to " + outFileName + " finished");

			if (foundNothing == true) {
				System.out.println("No match");
				out.write("\nKeine Übereinstimmungen gefunden.");
			}

		}

		// may be thrown by FileReader
		catch (FileNotFoundException fnf) {
			throw new FileNotFoundException(">> FileNotFoundException: " + fnf.getMessage());
		}

		// my be thrown by FileReader, FileWriter
		catch (IOException io) {
			throw new IOException(">> IOException: " + io.getMessage());
		}

		// these instructions are always executed
		finally {
			if (out != null)
				out.close();
			if (in != null)
				in.close();
			System.out.println("All closed");
		}

		return "done";
	}
}