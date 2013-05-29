/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Extra-Credit
 * File: ConfigModifierProgram
 * Info: This program helps user modify config file by prompting them about input.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ConfigModifierProgram 
{
	private static File file;
	
	public static void main(String[] args) throws FileNotFoundException,
	                                              ClassNotFoundException
	{
		//prompt user
		System.out.println("Please enter config file:");
		//check file 
		loadConfig();
		//create config class object 
		Config c = new Config(file);
		//load file into config class object
		c.load();
		//display current config file contents
		c.displayConfigFile();
		//call edit method 
		c.editExistingField();
		
		Scanner sc = new Scanner(System.in);
		//delete values
		//prompt user
		System.out.println("Do you wish to delete a key? Y/N");
		String input = sc.nextLine();
		//if yes call delete method 
		if(input.equalsIgnoreCase("Y"))
			c.delete();
		//done controls the while loop
		boolean done = false;
		while(!done)
		{
			//add values to config file
			System.out.println("Do you wish to add new key/value? Y/N");
			String answer = sc.nextLine();
			if(answer.equalsIgnoreCase("N"))
				done = true;
			if(done)
			{
				System.out.println("Done editing config file. Displaying file.");
				//current HashMap
				HashMap<String, Object> configHashMap = c.getConfigHashMap();
				c.display(configHashMap);
				//save
				c.save();
				//display
				c.displayConfigFile();
				//exit
				System.out.println("Exiting Program. Good Bye.");
				System.exit(0);
			}
			else
			{
				System.out.println("Enter new name of key: ");
				String key = sc.nextLine();
				c.addKey(key);
				c.addValue();
			}
		}
		
		
	}
	
	//*********************************loadConfig()*********************************
	public static void loadConfig()
	{
		//check if file is a config file
		boolean isConfigFile = false;
		while(!isConfigFile)
		{
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			file = new File(input);
			//only load file if it exists and extension is .conf
			if(file.exists() && input.contains(".conf"))
				isConfigFile = true;
			else
				System.out.println("Please re-enter file");
		}
	}
}
