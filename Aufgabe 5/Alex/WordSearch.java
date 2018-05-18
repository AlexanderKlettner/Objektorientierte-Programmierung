import java.io.*;

public class WordSearch{
   public static String search (String inFileName, String word)
    throws FileNotFoundException, IOException{
    
      String outFileName = "";    
      FileReader in = new FileReader(inFileName);
      
      //der Name der Datei, die schlussendlich erzeugt wird, wird hier festgelegt
      if(inFileName.contains(".")){
         outFileName = inFileName.replace(".","_"+word+".");
      }else outFileName = inFileName + "_" + word;
      
      FileWriter out = new FileWriter(outFileName);
      BufferedReader brIn = new BufferedReader(in);
      
      //um den Zeilenumbruch unabhängig vom Betriebssystem zu machen,
      //erfragt man sich hier den line separator
      String n = System.getProperty("line.separator");
      
      //jede neue Datei soll so beginnen:
      out.write("Zeilen mit dem Wort: " + word);
      out.write(n);
      
      //i gibt mir die Zeile an, die ich gerade einlese (Nummerierung)
      int i = 1;
      
      try{
      String line ="";
      //while schleife wird solange ausgeführt bis die eingelesene Zeile null ist
      while((line = brIn.readLine()) != null){
      //ein neuer String l wird erzeugt, der genau so aussieht wie line, aber ohne Sonderzeichen
         String l=line.replaceAll("[_[^\\w\\däüöÄÜÖ\\+\\- ]]", " ");
         //l wird bei Leerzeichen gesplittet und die Teile werden in ein array gegeben
         String[] words = l.split(" "); 
         //for-each Schleife: w bekommt immer den "Wert" des nächsten array elements
         for(String w: words){
         //wenn das Wort des arrays dem eingegebenen word entspricht soll der FileWriter beschrieben werden
            if(w.equals(word)){
               out.write(i+": "+line);
               out.write(n);
               
            }
         }i++;
      }
      
        }
      
      catch (FileNotFoundException e) {
        throw new FileNotFoundException(">> FileNotFoundException: " + e.getMessage());
      } 
      
      catch (IOException e) {
        throw new IOException(">> IOException: " + e.getMessage());
      }
      
        finally {   
        if (out!= null)
          out.close();
        if (in != null)
          in.close();
        System.out.println("All closed");
        }
      brIn.close();
      out.close(); 
               
    return "done";
  }
}      
