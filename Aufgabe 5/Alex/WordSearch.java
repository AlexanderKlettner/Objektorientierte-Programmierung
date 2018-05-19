import java.io.*;

public class WordSearch{
   public static String search (String inFileName, String word)
    throws FileNotFoundException, IOException{
    
      String outFileName = "";    
      FileReader in = new FileReader(inFileName);
      //outFileName wird hier noch angepasst.
      //Die seltenen Zeichen brauche ich als Identifikator der Stelle, an der _word eingefügt werden soll.
      String selteneZeichen ="-+*~#\\$§%{&]=?/€[<>|}!'@"; 
      int j=0;
      //Sollte inFileName wirklich alle seltenen Zeichen enthalten, wird um Umbenennung gebeten
      for(int i = 0;i<selteneZeichen.length();i++){
         if(inFileName.contains(selteneZeichen)){
            System.out.println("Nenn die Datei um!");
            break;
         }
         //Die Position des ersten seltenen Zeichens, welches nicht in inFileName enthalten ist, wird in j gespeichert
         if(inFileName.indexOf(selteneZeichen.charAt(i))==-1){
            j = i;
            break;
         }
      }   
      
      //Punkte könnten in Dateinamen öfters auftauchen. Ich suche hier den letzten Punkt.
      int letzterPunkt = inFileName.lastIndexOf(".");
      //inFileName wird in ein Array umgewandelt. Jedes Array-Element enthält einen Character von inFileName
      char[] inFileNameChar = inFileName.toCharArray();
      //Der letzte Punkt wird durch das seltene Zeichen ersetzt, das nicht in inFileName vorkommt.
      inFileNameChar[letzterPunkt] = selteneZeichen.charAt(j);
      //Das bearbeitete Array wird in einen String kopiert.
      String inFileNameFertig = String.copyValueOf(inFileNameChar);
      //Das seltene Zeichen in inFileNameFertig wird durch _word. ersetzt und als outFileName gespeichert
      outFileName = inFileNameFertig.replaceAll(Character.toString(selteneZeichen.charAt(j)),"_"+word+".");
      //FileWriter mit korrektem Namen wird erzeugt.
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
         
      
