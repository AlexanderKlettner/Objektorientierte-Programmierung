/*************************************************** 
Class WordSearch: 
UV Objektorientierte Programmierung 
Simone Mueller
***************************************************/
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class WordSearch{
   public static String search(String inFileName, String word)
      throws FileNotFoundException, IOException{
        
        int lenginp = inFileName.length(); 
      
        String outFileName = "";
        String outFileRest = "";
        
        if(inFileName.contains(".")){
         int index = inFileName.lastIndexOf(".");
            for(int k = 0; k < index; k++){
               outFileName = outFileName + inFileName.charAt(k);
            }
            
            for(int p = index; p < lenginp; p++){
               outFileRest = outFileRest + inFileName.charAt(p);
            } 
            
            outFileName = outFileName + "_" + word + outFileRest;
        }
        else{
         outFileName = inFileName + "_" + word;
        }
      
        FileWriter output = new FileWriter(outFileName);
        
        
        BufferedReader in = null;
        BufferedWriter out = null;
         
        try {
           //abstract base class for representing an input stream of bytes
           InputStream inStream = new FileInputStream(inFileName);
           //using a Reader for input
           Reader r = new InputStreamReader(inStream);
           //additional buffer and methods for efficient input
           in = new BufferedReader(r);
      
           //abstract base class for representing an output stream of bytes
           OutputStream outStream = new FileOutputStream(outFileName);
           //using a Writer for output
           Writer w = new OutputStreamWriter(outStream);
           //additional buffer efficient output
           out = new BufferedWriter(w);
           
           //First Line in Outputfile
           out.write("Zeile mit dem Wort: " + word);
           
           //Dealing with matching partial Strings
           String match = "\\b" + word + "\\b";
           Pattern pattern = Pattern.compile(match);
           
           Scanner scan = new Scanner(new File(inFileName));
           int m = 0; 
           
           while(scan.hasNext()){
               m = m+1;
               String line = scan.nextLine().toString();
               if(line.contains(word)){
                  String writeNow = "\n" + m + ": " + line;
                  out.write(writeNow);
               }
               else{
                 System.out.println("Keine Uebereinstimmungen"); 
                 out.write("\nKeine Uebereinstimmung gefunden.");
               }
           }

           System.out.println("Output to " + outFileName + " finished");
           
       }
           
           catch (FileNotFoundException e) {
            System.out.println(">> FileNotFoundExcpetion: " + e.getMessage());
           } 
           
           catch (IOException e2) {
            System.out.println(">> IOException: " + e2.getMessage());
           }
           
           //these instructions are always executed
           finally {   
           if (out!= null)
            out.close();
           if (in != null)
            in.close();
           System.out.println("All closed");
           }  
           
           return "done";
        } 
        
        
      
    }

