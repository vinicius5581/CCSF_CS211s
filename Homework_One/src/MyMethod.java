/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework #1
 */

import java.io.*;
import java.util.*;

public class MyMethod 
{
   /** This method takes in a file and stores its lines in an array.
    * 	
    * @param fileName is the name of the file.
    * @param numbLines is a parameter that gives the user capability
    *        of providing number of lines they wish to store from the
    *        file they provide. If no parameter is provided the default
    *        is to store the whole file.
    * @return an array of strings where each element stores a line from 
    *         the file.
    */
   public static String[] loadFile(String fileName, int ... numbLines)
   {
      // stores number of lines user wants from the file
	  // default is 0 which means store all lines in the file
	  int lines = 0;  
	  
	  //limitReached used to restrict number of lines stored 
	  boolean limitReached = false;
      
      //get number of lines from the array
	  for( int number : numbLines)
	  {
		lines = number;
	  }
	 
	  //Array where we will store the lines.
	  ArrayList<String> fileLines = new ArrayList<String>();

	  //Get the file and store its lines
	  try
      {
		 Scanner sc = new Scanner(new File(fileName));
         //store each line in a file into an element 
		 //stop storing lines if we reach limit on number of lines needed
   	     while (sc.hasNext() && !limitReached)
   	     {
   		    fileLines.add(sc.nextLine());
   		    lines--; //controls the line limit; does not interfere with default
   		    if(lines == 0)
   			   limitReached = true;
   	     }
      }
	  catch(FileNotFoundException e)
	  {
	     System.err.println("Bad file name or file does not exist");
	     System.exit(1);
	  }
	  catch(IOException e)
	  {
	     System.err.println("Cannot access file.");
	     System.exit(2);
	  }
	  
	  //convert ArrayList to String Array and return it
	  String[] arrayOfLines = new String[fileLines.size()];
	  fileLines.toArray(arrayOfLines);
	  
	  return arrayOfLines;
	  
   }
  
}