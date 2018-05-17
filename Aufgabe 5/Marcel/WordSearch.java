import java.io.*;


public class WordSearch {
	public static String search (String inFileName, String word)
		    throws FileNotFoundException, IOException{
		
		//For now only copies the file, and gives backe "word"
	    String outFileName = "textoutMarcel.txt";
	    
	  
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

	            
          	  String match = "Wort|\\SWort|Wort\\S|\\SWort\\S";
          	  System.out.println(match);
	            
	            
	            String line;
	            int lineNumber = 0;
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
	            	  System.out.println(parts[wordNr]);

    			  	  System.out.println(wordFound);
	            	  if(wordFound) {
	            		  //write file
	            		  //if word was found, then write the sentence and tell us which line number it was in
		            	  String writeMe = lineNumber + ": " + line;
		            	  if(in.ready()) {
		            		  //if theres another line to read in insert linebreak
		            		  // problem: may be a linebreak at the end of the file, where i dont need one
		            		  writeMe += "\n";
		            	  }
		            	  System.out.println(writeMe);
		            	  out.write(writeMe);      //write the index and the sentence that contained the word
	            	  }else wordNr++; //if not found, continue to check next word
	              }
	                          
	            }
	            System.out.println("Output to " + outFileName + " finished");
	            
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