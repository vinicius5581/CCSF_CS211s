/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework #3
 * File: Del.java
 */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Scanner;

public class Del 
{
   
   public static void main(String[] args) throws IOException 
   {
      //Array that will contain information passed by the user
      ArrayList<String> cmdLineInfo = new ArrayList<>();
      
      //check if any cmd line arguments passed
      if(args.length == 0)
      {
         //msg to user that they must specify a file to delete
         System.err.println("No files passed to delete.");
         System.exit(3);
      }
      
      //copy cmd line arguments into ArrayList
      boolean iOption = false;
      for(String info : args)
         cmdLineInfo.add(info);

      //check for iOption and any other cmd line arguments 
      if(cmdLineInfo.get(0).equals("-i"))
      {
         iOption = true;
         cmdLineInfo.remove(0);
      }
      
      //check if empty after checking for "-i" option
      if(cmdLineInfo.isEmpty())
      {
         //msg to user that they must specify a file to delete
         System.err.println("No files passed to delete.");
         System.exit(4);
      }
      
      //check if file(s) exists and obtain absolute path to file
      //remove item from list if it is not a file
      cmdLineInfo = checkFiles(cmdLineInfo);
      
      //exit program if there are no files to delete 
      if(cmdLineInfo.isEmpty())
         System.exit(5);
      
      //check if user has permission to delete file(s)
      //remove file from list if user does not have permission to delete that file
      cmdLineInfo = checkPermission(cmdLineInfo);
      
      //exit program if there are no files to delete 
      if(cmdLineInfo.isEmpty())
         System.exit(6);
      
      //check if .TrashCan directory exists and create it if it does not
      findTrashCan();
      
      //delete files by moving them into .TrashCan/fileOwner directory 
      for(int i = 0; i < cmdLineInfo.size(); i++)
         deleteFile(iOption, cmdLineInfo.get(i));
 

   }
   
   //******************************checkFiles()*************************************
   /**Method that checks if the file(s) exist or not. If file does not exist 
    *        the user is notified via message that contains file name. if 
    *        files does exist then obtain absolute path to file.
    * @param array is the array that contains information (files) from the user
    * @return an array that filtered out files that do not exist
    */
   private static ArrayList<String> checkFiles(ArrayList<String> array)
   {
      //check if file exists 
      int index = 0;
      while(index < array.size())
      {
         File f = new File(array.get(index));
         if(!f.isFile())
         {
            System.err.println("File " + array.get(index) + " does not exist.");
            array.remove(index);
            continue;
         }
         index++;
      }
       
      return array;
   }
 
   //******************************checkPermission()********************************
   /**Method that checks if file(s) that user wants to delete are owned by the user.
    *        if user is not the owner of the file then they are not able to delete
    *        that file.
    * @param files is an ArrayList that contains names of files that user wants to
    *        delete
    * @return an ArrayList that removed files that user is not able to delete. 
    * @throws IOException
    */
   private static ArrayList<String> checkPermission(ArrayList<String> files)
   throws IOException
   {
      String fileOwner;
      
      //obtain current user 
      String user = System.getProperty("user.name");
      //obtain owner of file(s) and check if current user is their owner
      for(int i = 0; i < files.size(); i++)
      {
         //get owner of the file
         Path p = Paths.get(files.get(i));
         UserPrincipal owner = Files.getOwner(p);
         fileOwner = owner.toString();
         //if user is not the owner prompt the user they cannot delete file
         if(!user.equals(fileOwner))
         {
            System.err.println("Cannot delete file. Not the owner.");
            //if file cannot be deleted then remove that file from the list 
            files.remove(i);
         }
      }
      return files;
   }
   
   //******************************findTrashCan()***********************************
   /**Method that searches for .TrashCan directory in your home directory. If
    *        .TrashCan directory does not exist then it is created and permissions
    *        are set. 
    * @throws IOException */
   private static void findTrashCan() throws IOException
   {
      //get user's home directory
      String userHome = System.getProperty("user.home");
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      //create .TrashCan 
      File f = new File(userHome + fileSeparator +".TrashCan");
      
      //check if TrashCan directory exits; if it does not create it
      if(!f.isDirectory())
      {
         f.mkdir();
         //set directory permissions to rwx rwx rwx t
         //NOTE: set sticky bit permissions 
         Process p;
         p = new ProcessBuilder("chmod", "ugo+rwxt", f.getAbsolutePath()).start();
      }

   }
   
   //******************************deleteFile()*************************************
   /**Method that first checks for "-i" option. If "-i" was used then user is 
    *        asked if they want to delete file otherwise the file is deleted. 
    * @param deleteCheck this is a parameter used to check if "-i" option was used.
    * @param file is the name of the file to be deleted. 
    * @throws IOException in case the file does not exist 
    */
   private static void deleteFile(boolean deleteCheck, String file) 
   throws IOException 
   {
      //first check if user passed -i option
      if(deleteCheck)
      {
         System.out.println("Are you sure you want to delete file? Y/N " + file );
         //if user does not want to delete file (returns a false) then exit method
         if(!deleteYN())
            return;
      }
      
      //create a sub-directory for user under .TrashCan based on owner of file
      createUserTrashDir(file);
      
      //rename file prior to compression and deletion 
      String renamedFile = renameFile(file);
      
      //compress file 
      compressFile(renamedFile);
      
      //move file to .TrashCan/owner directory 
      moveFile(renamedFile);
      
   }
   
   //******************************deleteYN()***************************************
   /**Method: Checks if user wants to delete a file. Input of "Y" will return true
    *         while input of "N" will return false. Only "Y" or "N" is allowed and
    *         user will be prompted to re-enter letter if input is not deemed valid.
    * @return boolean based on user's input. 
    */
   private static boolean deleteYN()
   {
      //need a scanner to obtain user's input
      Scanner sc = new Scanner(System.in);
      //use a loop to obtain correct user input: "Y" or "N" 
      while(true)
      {
         String answer = sc.nextLine().toUpperCase();
         if(answer.equals("N") || answer.equals("Y"))
            return (answer.equals("Y")); //return true if "Y" and false if "N"
         
         System.out.println("Are you sure you want to delete file? Y/N");
      }
      
   }
   
   //******************************createUserTrashDir()*****************************
   /**Method checks sub-directory exists under .TrashCan exists based on owner of 
    *        the file. If it does not exist then one is created.
    * @param file is the file to be deleted and whose ownership we obtain to check
    *        the existence of a sub-directory 
    * @throws IOException if file does not exist
    */
   private static void createUserTrashDir(String file) throws IOException
   {
      //get owner of the file
      Path p = Paths.get(file);
      UserPrincipal owner = Files.getOwner(p);
      
      //get user's home directory
      String userHome = System.getProperty("user.home");
      
      //get system file separator 
      String fileSeparator = System.getProperty("file.separator");
       
      File f = new File(userHome + fileSeparator +".TrashCan" 
                                 + fileSeparator + owner);
      
      //if sub-directory does not exist then create it based on owner of the file
      if(!f.isDirectory())
         f.mkdir();
      
   }
   
   //******************************renameFile()*************************************
   /**Method obtains absolute file path and then renames the file to absolute path 
    *        to file with file separators changed to "@" symbols 
    * @param file to be renamed
    * @return a renamed File
    */
   private static String renameFile(String file)
   {
      //first obtain system file separator
      String fileSeparator = System.getProperty("file.separator");
      
      //get absolute file path
      File f = new File(file);

      String fullPath = f.getAbsolutePath();
      //new name for file
      
      String newFile = fullPath.replaceAll(fileSeparator, "@");
      //rename file
      File fNew = new File(newFile);
      if(!f.renameTo(fNew))
      {
         System.err.println("Unable to delete file");
         System.exit(2);
      }
      
      return newFile;
   }
   
   
   //******************************compressFile()***********************************
   /**Method that obtains renamed file, compresses it and creates a zip container 
    *        with compressed file
    * @param renamedFile name of the file to be compressed
    * @throws IOException 
    */
   private static void compressFile(String renamedFile) throws IOException
   {
      Zip.zip(renamedFile);
   }
   
   //******************************moveFile()***************************************
   /**Method that moves compressed file to .TrashCan/fileOwner 
    * @param file is the compressed file to be moved
    * @throws IOException
    */
   private static void moveFile(String file) throws IOException
   {
      //delete old file in directory
      File oldFile = new File(file);
      oldFile.delete();
     
      //get user 
      String user = System.getProperty("user.name");
      //get user's home directory
      String userHome = System.getProperty("user.home");
      //get file separator
      String delim = System.getProperty("file.separator");
      
      //create destination file in .TrashCan
      File fdir = new File(userHome + delim +".TrashCan" + 
                                      delim + user + delim);
      
      //setup compressed file to be moved 
      String zFile = file + ".zip";
      File ffile = new File(zFile);

      //move file 
      Path pathFile = ffile.toPath();
      Path destFile = fdir.toPath();
      //move zipped file to .TrashCan
      Files.copy(pathFile, destFile.resolve(pathFile.getFileName()),
                              StandardCopyOption.REPLACE_EXISTING);
    
      //clean-up post copy
      ffile.delete();
 
   }


}
