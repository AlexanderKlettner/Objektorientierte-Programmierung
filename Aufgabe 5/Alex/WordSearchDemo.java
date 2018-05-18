import java.io.FileNotFoundException;
import java.io.IOException;

public class WordSearchDemo{
   public static void main(String[] args){
      try{
         WordSearch.search("wort.txt","Wort");
      }
      //may be thrown by FileReader 
      catch (FileNotFoundException e) {
        System.out.println(">> FileNotFound: " + e.getMessage());
      } 
      //my be thrown by FileReader, FileWriter
      catch (IOException e) {
        System.out.println(">> IOException: " + e.getMessage());
      } 

   }
}