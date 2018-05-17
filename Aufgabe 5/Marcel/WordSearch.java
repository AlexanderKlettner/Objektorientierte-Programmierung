import java.io.*;


public class WordSearch {
	public static String search (String inFileName, String word)
		    throws FileNotFoundException, IOException{
		  
		
		
		// append the "word" thing

	    String[] nameParts = inFileName.split("\\.");
	    String suffix = nameParts[nameParts.length - 1];
	    String rest = "";
	    
	    for(int i = 0; i < nameParts.length - 1; i ++) {
	    	rest = rest + nameParts[i];
	    }

	    String outFileName = rest + "_" + word + "." + suffix;
	    
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
	            
	          out.write("Zeilen mit dem Wort: " + word);
	            
          	  String match = word + "|\\S" + word + "|" + word + "\\S|\\S"  + word + "\\S";
//          	  System.out.println(match);
	            
	            
	            String line;
	            int lineNumber = 0;
	            boolean foundNothing = true;
	            while (in.ready()){
	              lineNumber++;
	              line = in.readLine(); //reading next line
	              boolean wordFound = false; //remove later on
	              //Checking if line contains the word
	              
	              //parts[i].matches("\\Shier\\S")
	              String[] parts = line.split(" "); //Split by whitespaces to get every word
	              
	              //Loop over every part and check if word is contained
	              int wordNr = 0;
	              while(wordFound == false && wordNr < parts.length) {
	            	  //parts[i].matches("\\Shier\\S")
	            	  wordFound = parts[wordNr].matches(match); // \\S to account for symbols like .(/\[ etc.
//	            	  System.out.println(parts[wordNr]);

//    			  	  System.out.println(wordFound);
	            	  if(wordFound) {
	            		  foundNothing = false;
	            		  //write file
	            		  //if word was found, then write the sentence and tell us which line number it was in
		            	  String writeMe = "\n" + lineNumber + ": " + line;
//		            	  System.out.println(writeMe);
		            	  out.write(writeMe);      //write the index and the sentence that contained the word
	            	  }else wordNr++; //if not found, continue to check next word
	              }
	              
	            
	                          
	            }
	            System.out.println("Output to " + outFileName + " finished");
	            
	            if(foundNothing == true) {
	            	  System.out.println("No match");
	            	  out.write("\nKeine Übereinstimmungen gefunden.");
	              }
	            
	        }
	    	
	    	//may be thrown by FileReader
	        catch (FileNotFoundException fnf) {
//	          System.out.println(">> FileNotFoundException: " + fnf.getMessage());
	          
//	          throw new ArithmeticException("Student is not eligible for registration"); 
	          throw new FileNotFoundException(">> FileNotFoundException: " + fnf.getMessage());
	        } 
	    	
	        //my be thrown by FileReader, FileWriter
	        catch (IOException io) {
	          throw new IOException(">> IOException: " + io.getMessage());
//	          System.out.println(">> IOException: " + io.getMessage());
//	          throw new IOException();
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