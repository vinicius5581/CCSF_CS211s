/**
 * @author Victor Malchikov
 * File: DemoIPAddress.java
 * Purpose: This class uses IPAdress.java class to demonstrate 
 *          its capabilities. 
 * Homework #2
 */

public class DemoIPAddress
{
	public static void main(String[] args)
	{
		//create an object of IPAddress 
	   IPAddress ipAddress = new IPAddress();
	   //generate non-unique IP addresses 
	   System.out.println("gen() method in use: ");
	   System.out.println("*********Generate 100 random non-unique IP Addresses***");
		String[] ipAddresses = new String[50];
      
		ipAddresses = ipAddress.gen(50);
		
	   System.out.println("*******************ADD DUPLICATE IPs*******************");
      System.out.println("0.0.0.1");
      System.out.println("0.0.0.1");
      ipAddresses[30] = "0.0.0.1";
      ipAddresses[20] = "0.0.0.1";
      
      System.out.println("***********************DISPLAY*************************");
		for(String ip : ipAddresses)
		{
			System.out.println(ip);
		}
		
		System.out.println("\nsort() method in use: ");
		
		//sort 50 random non-unique IP Addresses 
		System.out.println("\n**********Sort 50 random non-unique IP Addresses*****");
		ipAddress.sort(ipAddresses);
	   //print sorted addresses 
		for(String ip : ipAddresses)
	   {
	      System.out.println(ip);
	   }
		//show length 
		System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
		//remove duplicates 
	   System.out.println("\n**************AFTER REMOVAL OF DUPLICATES************");
	   ipAddresses = ipAddress.uniq(ipAddresses);
	   for(String ip : ipAddresses)
	   {
	      System.out.println(ip);
	   }
	   //show length after removal of duplicates 
	   System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
	   
	   //generate unique IP addresses 
	   System.out.println("\nugen() method in use: ");
	   System.out.println("\n*********Generate 50 random unique IP Addresses******");
	
	   ipAddresses = ipAddress.ugen(50);

	   for(String ip : ipAddresses)
	   {
	      System.out.println(ip);
	   }
	      
	   //sort 50 random unique IP Addresses
	   System.out.println("\nsort() method in use: ");
	   System.out.println("\n**********Sort 50 unique IP Addresses****************");    
	   ipAddress.sort(ipAddresses);
	   //display sorted  
	   for(String ip : ipAddresses)
	   {
	      System.out.println(ip);
	   }
	   //show number of IP addresses 
      System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
      //show that there are no duplicates created 
      System.out.println("\nuniq() method in use: ");
      System.out.println("\n**************AFTER REMOVAL OF DUPLICATES************");
      ipAddresses = ipAddress.uniq(ipAddresses);
      for(String ip : ipAddresses)
      {
         System.out.println(ip);
      }
      //show length after removal of duplicates (same length shown)
      System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
      
      //show better display of sort method
      System.out.println("\nsort() method in use: ");
		System.out.println("*****************Better sort() display*****************");
		
		//Better sort visual:
		ipAddresses = ipAddress.gen(19);
		
		ipAddresses[0] = "10.9.0.0";
		ipAddresses[1] = "9.10.0.0";
		ipAddresses[2] = "1.1.2.1";
		ipAddresses[3] = "1.1.1.2";
		ipAddresses[4] = "1.1.1.0";
		ipAddresses[5] = "1.1.2.0";
	   ipAddresses[6] = "1.1.1.1";
		ipAddresses[7] = "1.2.0.0";
		ipAddresses[8] = "9.9.9.9";
		ipAddresses[9] = "1.2.1.1";
		ipAddresses[10] = "0.0.0.1";
		ipAddresses[11] = "1.1.1.1";
		ipAddresses[12] = "0.0.0.2";
      ipAddresses[13] = "1.2.1.1";
      ipAddresses[14] = "0.0.0.0";
      ipAddresses[15] = "0.0.1.0";
      ipAddresses[16] = "0.0.2.0";
      ipAddresses[17] = "0.1.0.0";
      ipAddresses[18] = "0.2.0.0";
     
		System.out.println("\n******************BEFORE SORT************************");
		for(String ip : ipAddresses)
	   {
		   System.out.println(ip);
	   }
		
		System.out.println("\n*******************AFTER SORT************************");
		
		ipAddresses = ipAddress.sort(ipAddresses);
      for(String ip : ipAddresses)
      {
         System.out.println(ip);
      }
      
      //show length of array and duplicates inside it
      System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
      System.out.println("NOTE: There are 2 duplicate IP Addresses");
      System.out.println("1.2.1.1");
      System.out.println( "1.1.1.1");
      
      //remove duplicates 
      System.out.println("\nuniq() method in use: ");
		System.out.println("\n**************AFTER REMOVAL OF DUPLICATES************");
		ipAddresses = ipAddress.uniq(ipAddresses);
		for(String ip : ipAddresses)
      {
         System.out.println(ip);
      }
	   
		//show length of array post removal of duplicates 
		System.out.println("\nNumber of IP Addresses: " + ipAddresses.length);
		
		//show use of head and tail methods 
		System.out.println("\nhead() method in use: ");
	   System.out.println("\n********** Get first 5 IP Addreseses using head()****");
	   
	   ipAddress.head(ipAddresses, 5);
	   System.out.println("\nhead() method in use: ");
	   System.out.println("\n**********User asks for FIRST 20 IP Addresess********");
	   ipAddress.head(ipAddresses, 20);
	   
	   System.out.println("\ntail() method in use: ");
	   System.out.println("\n********** Get last 5 IP Addreseses using tail()*****");
	   
	   ipAddress.tail(ipAddresses, 5);
	   System.out.println("\ntail() method in use: ");
	   System.out.println("\n**********User asks for LAST 20 IP Addresess*********");
	   ipAddress.tail(ipAddresses, 20);
		
	}

}
