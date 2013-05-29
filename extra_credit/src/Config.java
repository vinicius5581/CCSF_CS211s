/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Extra-Credit
 * File: Config.java 
 * Info: This is a class that helps user modify a config file. User can upload,
 *       and use methods provided by this class to modify the file OR they could
 *       obtain config file in a HashMap<String, Object>, provide their own 
 *       modifications, and upload new configurations into config file. User is 
 *       given freedom to create their own HashMap configuration and then 
 *       upload/save it OR they can use class provided methods to add/display/modify
 *       existing config file.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Config
{
	private File configFile; //config file to edit
	private HashMap<String, Object> configuration; //key,value data of config file
	private ArrayList<String> comments = new ArrayList<String>(); //comments in file
	private String newKey; //used to store new key based on user input
	private Scanner sc; //used to read input / file 
	
	//***************************Config()****************************************
	//constructor
	public Config(File fileName)
	{
		configFile = fileName;
		configuration = new HashMap<>();
	}
	
	//***************************load()*****************************************
	//load config file into HashMap<key, value>
	public HashMap<String, Object> load()
	{
		try 
		{
			//read file into HashMap. 
			sc = new Scanner(configFile); 
			while(sc.hasNext())
			{
				String tmp = sc.nextLine();
				parseLine(tmp); //parse config file based on key/object
			}
		}
		catch (FileNotFoundException e)
		{
			System.err.println("unable to load");
			e.printStackTrace();
			System.exit(1);
		}
		
		return configuration; //give the user back current config file
	}
	
	//***************************editExistingField()******************************
	public void editExistingField() throws ClassNotFoundException
	{
		//prompt user
		System.out.println("****Editing existing config file values.****");
		System.out.println("Type \"done\" to quit.");
		//done stops ends editing 
		boolean done = false;
		sc = new Scanner(System.in);
		while(!done)
		{
			//prompt user
			System.out.println("Please enter key: ");
			//obtain use input
			String input = sc.nextLine();
			//exit editing
			if(input.equalsIgnoreCase("done"))
			{
				done = true;
				break;
			}
			//check if key is in the config file
			if(!configuration.containsKey(input))
				continue;
			else
			{
				//prompt user
				System.out.println("Enter new value: ");
				Object tmp = configuration.get(input);
				boolean successfulAdd = false;
				//obtain name of Object
				String className = tmp.getClass().getSimpleName();
				while(!successfulAdd)
				{
					try
					{
				        //check if String
						if(className.equals("String"))
						{
							String s = sc.nextLine();
							configuration.put(input, s);
						}
						//check if Integer
						if(className.equals("Integer"))
						{
							Integer i = sc.nextInt();
							configuration.put(input, i);
						}
						//check if Double
						if(className.equals("Double"))
						{
							Double d = sc.nextDouble();
							configuration.put(input, d);
						}
						//check if Long
						if(className.equals("Long"))
						{
							Long l = sc.nextLong();
							configuration.put(input, l);
						}
						//check if Short
						if(className.equals("Short"))
						{
							Short s = sc.nextShort();
							configuration.put(input, s);
						}
						//check Boolean
						if(className.equals("Boolean"))
						{
							String s = sc.nextLine();
							//check if true or false 
							if(s.equals("true") || s.equals("false"))
							{
								Boolean b = Boolean.valueOf(s);
								configuration.put(input, b);
							}
							else 
								throw new Exception(); //bad data entered 
						}
						//check Byte
						if(className.equals("Byte"))
						{
							String s = sc.nextLine();
							//check if Byte
							Byte b = Byte.valueOf(s);
							configuration.put(input, b);
						}
						//check Float
						if(className.equals("Float"))
						{
							Float f = sc.nextFloat();
							configuration.put(input, f);
						}
						//check if Character
						if(className.equals("Character"))
						{
							String c = sc.nextLine();
							if(c.length()>1 || c.length()<1 || c.isEmpty())
								throw new Exception(); //bad input - force exception
							else
							{
								Character ch = c.charAt(0);
								configuration.put(input, ch);
							}
						}
					}
					catch(Exception e) 
					{
						System.out.println("Wrong data type.");
					}
					
					//check if done editing
					sc.nextLine(); //clear buffer
					System.out.println("Continue editing? Y/N");
					String check = sc.nextLine();
					//exit editing
					if(check.equalsIgnoreCase("N"))
					{
						successfulAdd = true;
						done = true;
					}
					else
						break; //to get back to outter loop to get new key
				}
			}
		
	
		}
		
	}//close method
	
	//***************************uploadHashMapConfig()******************************
	public void uploadHashMapConfig(HashMap<String, Object> config)
	{
		configuration = config;
	}
	
	//***************************display(HashMap<String, Object)********************
	public void display(HashMap<String, Object> config)
	{
		//convert HashMap to Set - to gain access to Iterator
		Set<String> tmp = configuration.keySet();
		Iterator<String> it = tmp.iterator(); //create Iterator
		while(it.hasNext())
		{
			String key = it.next();
			String value = configuration.get(key).toString();
			System.out.println(key + " = " + value); //display key = value		
		}
	}
	
	//***************************display()****************************************
	public void displayConfigFile() throws FileNotFoundException
	{
		//display configFile 
		sc = new Scanner(configFile);
		while(sc.hasNext())
		{
			System.out.println(sc.nextLine());
		}
	}
	
	//***************************parseLine()**************************************
	private void parseLine(String line)
	{
		//ignore lines with // (store them in array)
		if(line.startsWith("//"))
		{
			comments.add(line);
		}
		if(line.contains("="))
		{
			//obtain key (string)
			int delim = line.indexOf("=");
			String key = line.substring(0, delim);
			key = key.trim();
			//obtain value (object)
			String val = line.substring(delim+1, line.length());
			val = val.trim();
			//remove extra comments after value
			if(val.contains("//"))
			{
				val = val.substring(0, val.indexOf("/"));
			}
			//check if String
			if(val.contains("\""))
			{
				configuration.put(key, val);
				return;
			}
			//check if Character
			if(val.contains("\'") && (val.length() == 3))
			{
				Character c = val.charAt(1);
				configuration.put(key, c);
				return;
			}
			//check if Boolean
			if(val.equals("true") || val.equals("false"))
			{
				Boolean b = Boolean.valueOf(val);
				configuration.put(key, b);
				return;
			}
			//check if Integer
			try
			{
				Integer i = Integer.parseInt(val);
				configuration.put(key, i);
				return;
			}
			catch (NumberFormatException e) { }
			//check if Double
			try
			{
				Double d = Double.valueOf(val);
				configuration.put(key, d);
				return;
			}
			catch(NumberFormatException e) {}
			//check if Float 
			try
			{
				Float f = Float.valueOf(val);
				configuration.put(key, f);
				return;
			}
			catch(NumberFormatException e) {}
			//check if Long
			try
			{
				Long l = Long.valueOf(val);
				configuration.put(key, l);
				return;
			}
			catch(NumberFormatException e) {}
			//check if Byte
			try
			{
				Byte b = Byte.valueOf(val);
				configuration.put(key, b);
				return;
			}
			catch(NumberFormatException e) {}
			//check if Short
			try
			{
				Short s = Short.valueOf(val);
				configuration.put(key, s);
				return;
			}
			catch(NumberFormatException e) {}
		}
	}
	
	//***************************addKey()******************************************
	public void addKey(String name)
	{
		newKey = name; //this is used in conjunction with addValue()
	}
	
	//***************************addValue()***************************************
	public void addValue()
	{
		//done controls editing of config
		boolean done = false;
		//obtain info from user
		sc = new Scanner(System.in);
		String dataType = "?";
		//check dataType
		while(!done)
		{	
			System.out.println("What type of data? Correct spelling required.");
	
			dataType = sc.nextLine();
			try
			{
				//if Integer
				if(dataType.equals("Integer"))
				{
					System.out.println("Enter value: ");
					Integer i = sc.nextInt();
					configuration.put(newKey, i);
				}
				//if Double
				else if(dataType.equals("Double"))
				{
					System.out.println("Enter value: ");
					Double d = sc.nextDouble();
					configuration.put(newKey, d);
				}
				//if Short
				else if(dataType.equals("Short"))
				{
					System.out.println("Enter value: ");
					Short s = sc.nextShort();
					configuration.put(newKey, s);
				}
				//if Long
				else if(dataType.equals("Long"))
				{
					System.out.println("Enter value: ");
					Long l = sc.nextLong();
					configuration.put(newKey, l);
				}
				//if Float
				else if(dataType.equals("Float"))
				{
					System.out.println("Enter value: ");
					Float f = sc.nextFloat();
					configuration.put(newKey, f);
				}
				//if Boolean
				else if(dataType.equals("Boolean"))
				{
					System.out.println("Enter value: ");
					String in = sc.nextLine();
					if(in.equals("true") || in.equals("false"))
					{	
						Boolean b = Boolean.valueOf(in);
						configuration.put(newKey, b);
					}
					else
						throw new Exception(); //bad input type
	
				}
				//if Byte
				else if(dataType.equals("Byte"))
				{
					System.out.println("Enter value: ");
					Byte b = Byte.valueOf(sc.nextLine());
					configuration.put(newKey, b);
				}
				//if String
				else if(dataType.equals("String"))
				{
					System.out.println("Enter value: ");
					String s = sc.nextLine();
					configuration.put(newKey, s);
				}
				//if Character
				else if(dataType.equals("Integer"))
				{
					System.out.println("Enter value: ");
					String c = sc.nextLine();
					if(c.isEmpty() || c.length() < 1 || c.length() > 1)
						throw new Exception(); //bad input type from user (not char)
					else
					{
						Character ch = c.charAt(0);
						configuration.put(newKey, ch);
					}
					
				}
				else
				{
					System.out.println("Bad data type.");
				}
				done = true;
			}
			catch (Exception e)
			{
				System.out.println("Value did not match data type."); 
			}
	
		}
		
	}//exit addValue()
	

	//***************************delete()******************************************
	public void delete()
	{
		sc = new Scanner(System.in); 
		boolean done = false; 
		while(!done)
		{	
			//prompt user 
			System.out.println("Enter name of key to delete:");
			System.out.println("Type \"done\" to exit.");
			//get input 
			String key = sc.nextLine();
			if(key.equalsIgnoreCase("done")) //exit 
				break;
			if(!configuration.containsKey(key)) //key does not exist 
			{
				System.out.println("Key does not exist. Type \"done\" to exit.");
			}
			else
				configuration.remove(key); //delete key
		}
	}
	
	//***************************getConfigHashMap()********************************
	public HashMap<String, Object> getConfigHashMap()
	{
		return configuration; 
	}

	
	//***************************save(HashMap)**************************************
	public void save(HashMap<String, Object> configFile)
	{
		configuration = configFile; //user can provide their own config changes
		save(); //call default save() method
	}
	
	
	//***************************save()*********************************************
	public void save()
	{
		//convert HashMap to Set - to gain access to Iterator
		Set<String> tmp = configuration.keySet();
		Iterator<String> it = tmp.iterator(); //create Iterator

		try
		{
			//override old config file with new data 
			FileOutputStream fos = new FileOutputStream(configFile);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			//copy first 3 lines of comments 
			for(int i = 0; i < comments.size()-2; i++)
			{
				osw.write(comments.get(i)+"\n");
			}
			//copy data 
			while(it.hasNext())
			{
				String key = it.next();
				String value = configuration.get(key).toString();
				osw.write(key+ " = " + value+ "\n");
			}
			//copy last 2 lines of comments 
			for(int i = 3; i < comments.size(); i++)
				osw.write(comments.get(i)+"\n");
			
			osw.flush();
			osw.close();
		}
		catch(IOException e)
		{
			System.err.println("Something went wrong.");
			System.exit(2);
		}
	}
}
