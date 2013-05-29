

public class Driver 
{
  public static void main(String[] args)
  {
	
	System.out.println("Sample Output: Full file.\n");  
	String file = "readMe.txt";
    String[] lines = MyMethod.loadFile(file);
    
    for(int i = 0; i < lines.length; i++)
       System.out.println(lines[i]);
   
    System.out.println("\nSample Output: User wants first 5 lines. \n");
    String[] newLines = MyMethod.loadFile(file, 05);
    
    for(int i = 0; i < newLines.length; i++)
    	System.out.println(newLines[i]);
  }
  
}
