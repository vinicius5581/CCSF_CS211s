/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework #2
 * File: IPAddress.java
 */

import java.util.ArrayList;
import java.util.Arrays;

public class IPAddress
{
   //********************************gen()*************************************
   /** This method takes in an integer and generates that many non-unique 
    *   IP addresses and stores them as strings in an array.
    *   @param number is the number of non-unique IP Addresses user wants.
    *   @return an array of Strings where each element is an IP address. 
    */
   public String[] gen(int number)
   {
	   //ipArray will store IP addresses  
	   String[] ipArray = new String[number];

	   //generate non-unique IP Addresses
	   //ipGenerator() method used to generate IP addresses 
		for(int i = 0; i < ipArray.length; i++)
		   ipArray[i] = ipGenerator();

	   return ipArray;
   }
   
   //********************************guen()**************************************
   /**Method generates a specified amount of unique IP addresses and returns a 
    *        them in a String array. 
    * @param number is the desired amount of unique IP addresses
    * @return a String array of unique IP addresses. 
    */
   public String[] ugen(int number)
   {
      //ipArray will store IP addresses  
      ArrayList<String> ipArray = new ArrayList<String>();
      
      String ip;
      //index used as counter for loop
      int index = 0;
      //checkIP used to find out if array contains IP
      boolean checkIP;
      //pass in true to generate unique IP and number for desired amount
      while(index < number)
      {
         //ipGenerator() method used to generate IP addresses
         ip = ipGenerator();
         //check if unique
         checkIP = findIP(ipArray, ip);
         if(!checkIP)
         {
            ipArray.add(ip);
            index++;
         }
      }
      
      //convert to String array and return it
      String[] array = new String[number];
      return ipArray.toArray(array);
   }
 
   //********************************sort()***********************************
   /**Method designed to sort an array of IP addresses in ascending 
    * order (small to large)
    * @param ipArray is an array of IP Addresses that are stored 
    *        as Strings
    * @return a String array of sorted IP Addresses 
    */
   public String[] sort(String[] array)
   {     
    
      //check if IP needs to be padded with 0's prior to sort
      for(int i = 0; i < array.length; i++)
      {
         //Pad IP with 0's so it can be sorted properly 
         array[i] = pad(array[i]);
      }
      
      //sort IP Addresses 
      Arrays.sort(array);
      
      //UN-pad the sorted array
      for(int i = 0; i < array.length; i++)
      {
         array[i] = unPad(array[i]);
      }
      
      //return sorted array
      return array;  
   }

   //********************************uniq()***************************************** 
   /**Method that accepts an array of non-unique IP Addresses and removes duplicates
    * @param array is the array of non-unique IP Addresses
    * @return a String array containing unique IP Addresses 
    */
   public String[] uniq(String[] array)
   {
      //sort and create an ArrayList containing IP addresses
      String[] sortedArray = sort(array);
      ArrayList<String> ipArray = new ArrayList<String>(Arrays.asList(sortedArray));
      //index will be used to control loop and to check element of the array 
      int index = 0;
      while(index < ipArray.size())
      {
         if( findIP(ipArray, ipArray.get(index), index))
            ipArray.remove(index+1);
         else
            index++;
      }
      
      //convert array back to String array and return
      String[] newArray = new String[ipArray.size()];
      return ipArray.toArray(newArray);
   }

   //********************************head()*****************************************  
   /**Method returns a number of IP Addresses from head of the array 
    * @param array is the array from which user wants information 
    * @param number is number of IP Addresses user wants displayed 
    */
   public void head(String[] array, int n)
   {
      //ensure that if n > array.length all elements are printed
      int number = n;
      if(number > array.length)
         number = array.length;
      //print   
      for(int i = 0; i < number; i++)
         System.out.println(array[i]);
   }

   //********************************tail()*****************************************   
   /** Method returns a number of IP Addresses form end of the array
    * @param array is the array from which user wants information 
    * @param number is number of IP Addresses user wants displayed
    */
   public void tail(String[] array, int n)
   {
      //ensure that if n > array.length all elements are printed
      int number = n;
      if(number > array.length)
         number = array.length;
      //print   
      for(int i = array.length-number; i < array.length; i++)
         System.out.println(array[i]);
   }
   
   //********************************ipGenerator()********************************** 
   /** Method used internally by the class to generate an IP Address 
    * @return String representation of IP
    */
   private String ipGenerator()
   {
      //ipFull is going to contain full IP Address
      String ipFull= "";
      
      //following 4 strings create an IP Address 
      String ip1 = "" + (int)(Math.random() * 256);
      String ip2 = "" + (int)(Math.random() * 256);
      String ip3 = "" + (int)(Math.random() * 256);
      String ip4 = "" + (int)(Math.random() * 256);

      //IP Address is properly put together 
      ipFull = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
     
      return ipFull;
   }

   //********************findIP(ArrayList<String> array, String ip)***************** 
   /**Method determines if IP Address exists in the array
    * @param array is array to be checked for duplicates
    * @param ip is the IP we are trying to find in array.
    * @return
    */
   private boolean findIP(ArrayList<String> array, String ip)
   {
      //compare IP to those stored in array
      for(int i = 0; i < array.size(); i++)
      {
         if(array.get(i).equals(ip))
            return true;
      }
      
      return false;
   }//end of method

   //******************findIP(ArrayList<String> array, String ip, int index)********
   /**Method determines if IP Address exists in the array
    * @param array is array to be checked for duplicates 
    * @param ip is the IP we are trying to find in array
    * @param index is where in array we start checking
    * @return
    */
   private boolean findIP(ArrayList<String> array, String ip, int index)
   {
      //since array is sorted we only have to check next IP in array 
      if(index+1 != array.size() && array.get(index+1).equals(ip))
         return true;
      else
         return false;
     
   }//end of method

   //********************************unPad()****************************************   
   /**Method removes zeroes from padded IP Address and returns unpadded IP
    * @param ip is a String that needs to be modified 
    * @return String that has been modified
    */
   private String unPad(String ip)
   {
      //break IP into 4 parts
      String one = ip.substring(0, 3);
      String two = ip.substring(3, 6);
      String three = ip.substring(6, 9);
      String four = ip.substring(9, ip.length());
      
      //remove padded zeroes from each part 
      //remove padded zeroes from part one
      for(int i = 0; i < one.length(); i++)
      {
         if(one.startsWith("0"))
            one = one.substring(1, one.length());
         else
            break;
      }
      //remove padded zeroes from part two
      for(int i = 0; i < two.length(); i++)
      {
         if(two.startsWith("0"))
            two = two.substring(1, two.length());
         else 
            break;
      }
      //remove padded zeroes from part three
      for(int i = 0; i < three.length(); i++)
      {
         if(three.startsWith("0"))
            three = three.substring(1, three.length());
         else
            break;
      }
      //remove padded zeroes from part four
      for(int i = 0; i < four.length(); i++)
      {
         if(four.startsWith("0"))
            four = four.substring(1, four.length());
         else
            break;       
      }
      
      //put the IP address back together and return it
      String address = one + "." + two + "." + three + "." + four;
      
      return address;  
   }

   //********************************pad()******************************************   
   /**Method pads an IP Address with 0's and removes "." 
    * @param ip is the String representation of IP Address
    * @return padded IP in String form
    */
   private String pad(String ip)
   {
      //paddedIP is the ip to be returned
      String paddedIP;
      
      //IP length is 15 then remove "." and return
      if(ip.length() == 15)
      {
         paddedIP = ip.replaceAll("\\.", "");
         return paddedIP;
      }
      
      //find where "." is in the string
      int firstDot = ip.indexOf(".");
      int secondDot = ip.indexOf(".", firstDot+1);
      int thirdDot = ip.indexOf(".", secondDot+1);
      
      //break IP into 4 parts based on "." position 
      String one = ip.substring(0, firstDot);
      String two = ip.substring(firstDot+1, secondDot);
      String three = ip.substring(secondDot +1, thirdDot);
      String four = ip.substring(thirdDot+1, ip.length());
      
      //obtain length of each IP part
      int oneLength = one.length();
      int twoLength = two.length();
      int threeLength = three.length();
      int fourLength = four.length();
      
      //Pad each IP part based on length 
      switch (oneLength)
      {
         case 1: one = "00" + one;
         break;
         case 2: one = "0" + one;
         break;
      }

      switch (twoLength)
      {
         case 1: two = "00" + two;
         break;
         case 2: two = "0" + two;
         break;
      }
      
      switch (threeLength)
      {
         case 1: three = "00" + three;
         break;
         case 2: three = "0" + three;
         break;
      }
      
      switch (fourLength)
      {
         case 1: four = "00" + four;
         break;
         case 2: four = "0" + four;
         break;
      }
     
      //put IP back together 
      paddedIP = one + two + three + four;

      //return IP
      return paddedIP;
   }

}
