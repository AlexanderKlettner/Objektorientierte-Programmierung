/*************************************************** 
Class WordSearch: 
UV Objektorientierte Programmierung 
Simone Mueller
***************************************************/
import java.io.*;
import java.util.Scanner;


public class WordSearch{
   public static String search(String inFileName, String word)
      throws FileNotFoundException, IOException{
        
        int lenginp = inFileName.length(); 
        
        String wordleer = word + " ";
        String wordausr = word + "!";
        String wordpkt = word + ".";
        String wordsemi = word + ";";
        String wordkomm = word + ",";
        String worddpkt = word + ":";
        String wordfrag = word + "?";
      
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
        
        //um den Zeilenumbruch unabhängig vom Betriebssystem zu machen,
        //erfragt man sich hier den line separator
        String sep = System.getProperty("line.separator");
         
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
           out.write(sep);
      
           
           Scanner scan = new Scanner(new File(inFileName));
           int m = 0; 
           
           while(scan.hasNext()){
               m = m+1;
               String line = scan.nextLine().toString();
               
               int laengezeile = line.length();
               int laengeword = word.length();
               
               
               if(laengezeile == laengeword || line.contains(wordleer) || line.contains(wordausr) || line.contains(wordpkt) || line.contains(wordsemi) || line.contains(wordkomm) || line.contains(worddpkt) || line.contains(wordfrag)){
                  String writeNow = "\nZeile " + m + ": " + line;
                  out.write(writeNow);
                  out.write(sep);
                  System.out.println("Zeile " + m + ": " + line);
               }
               else{
                 System.out.println("Zeile " + m + ": " + "Keine Uebereinstimmung gefunden."); 
                 out.write("\nZeile " + m + ": " + "Keine Uebereinstimmung gefunden.");
                 out.write(sep);
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

