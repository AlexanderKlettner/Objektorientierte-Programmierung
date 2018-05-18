import java.io.FileNotFoundException;
import java.io.IOException;

public class WordSearchDemo {
	public static void main (String[] args) {	
		
		
		//Mit Orginal text File aus Angabe
		
		//Einmal mit "Wort"
		try{
			WordSearch.search("textin.txt", "Wort");
		}
		catch(FileNotFoundException fnf) {
	        System.out.println();
			System.out.println(fnf.getMessage());
		}
	
		catch(IOException io) {
	        System.out.println();
			System.out.println(io.getMessage());
		}
		
		//Einmal mit "Wor"
		try{
			WordSearch.search("textin.txt", "Wor");
		}
		catch(FileNotFoundException fnf) {
	        System.out.println();
			System.out.println(fnf.getMessage());
		}
	
		catch(IOException io) {
	        System.out.println();
			System.out.println(io.getMessage());
		}
		
		
		
		// Modifziziertes File, um es etwas schwerer zu machen "(Wort)" und "Worte" enthalten
		//Einmal mit "Wort"
		try{
			WordSearch.search("text_modified.txt", "Wort");
		}
		catch(FileNotFoundException fnf) {
	        System.out.println();
			System.out.println(fnf.getMessage());
		}
	
		catch(IOException io) {
	        System.out.println();
			System.out.println(io.getMessage());
		}
		//Einmal mit "Wor"
		try{
			WordSearch.search("text_modified.txt", "Wor");
		}
		catch(FileNotFoundException fnf) {
	        System.out.println();
			System.out.println(fnf.getMessage());
		}
	
		catch(IOException io) {
	        System.out.println();
			System.out.println(io.getMessage());
		}
		
	}
}
