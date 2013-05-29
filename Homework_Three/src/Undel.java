/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework #3
 * File: Undel.java
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Undel
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
         System.exit(1);
      }
      
      //check if .TrashCan directory exists 
      if(!findTrashCan())
      {
         System.err.println("You do not have any files that you can recover.");
         System.exit(2);
      }
      
      //check if user has a sub-directory under .TrashCan 
      if(!findTrashCanOwnerSubDirectory())
      {
         System.err.println("You do not have any files that you can recover.");
         System.exit(3);
      }
      
      //check if user has any files in his sub-directory
      if(checkSubDirecotryForFiles())
      {
         System.err.println("You do not have any files in trashcan.");
         System.exit(4);
      }
      
      //copy cmd line arguments into ArrayList
      for(String info : args)
         cmdLineInfo.add(info);

      //restore files
      restoreFiles(cmdLineInfo);
      
      //if no files deleted by owner in .TrashCan then give msg and exit


   }
   
   //******************************findTrashCan()***********************************
   /**Method that checks if .TrashCan directory exists. It should be located under
    *  user's home directory. 
    * @return false if it does not exist.
    * @throws IOException
    */
   private static boolean findTrashCan() throws IOException
   {
      File f = getTrashCan();
      //check if TrashCan directory exits
      return f.isDirectory();
   }
   
   //******************************getTrashCan()************************************
   /**Method that obtains absolute path to .TrashCan directory
    * @return File of .TrashCan directory
    */
   private static File getTrashCan()
   {
      //get user's home directory
      String userHome = System.getProperty("user.home");
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      //create .TrashCan 
      File trashCanPath = new File(userHome + fileSeparator +".TrashCan");
      
      return trashCanPath;
   }
   
   //***************************findTrashCanOwnerSubDirectory()*********************
   /**Method that checks if user has their own subdirectory under .TrashCan dir.
    * @return false if they do not have a subdirectory under .TrashCan directory.
    * @throws IOException
    */
   private static boolean findTrashCanOwnerSubDirectory() throws IOException
   {
      File trashCanSub = getTrashCanSubDirectory();
      //if sub-directory does not exist then user cannot restore files
      return trashCanSub.isDirectory();
   }
   
   //******************************getTrashCanSubDirectory()************************
   /**Method that obtains absolute path to .TrashCan/OwnerSubdirectory
    * @return File of .TrashCan/OwnerSubdirectory
    */
   private static File getTrashCanSubDirectory()
   {
      //get user
      String user = System.getProperty("user.name");
      
      //get user's home directory
      String userHome = System.getProperty("user.home");
      
      //get system file separator 
      String fileSeparator = System.getProperty("file.separator");
       
      File trashCanSubDir = new File(userHome + fileSeparator +".TrashCan" 
                                 + fileSeparator + user);
      return trashCanSubDir;
   }
    
   //******************************checkSubDirectoryForFiles()**********************
   /**Method that checks if there are any files that this user owns in the .TrashCan
    * @return true if there are files that user can restore; false if there are none
    */
   private static boolean checkSubDirecotryForFiles()
   {
      //get .TrashCan subdirectory 
      File trashCanSubDir = getTrashCanSubDirectory();
      //obtain files in .TrashCan/Owner 
      File[] trashFiles = trashCanSubDir.listFiles();
      //check if there are any files inside directory
      return (trashFiles.length == 0);    
   }
   
   //******************************restoreFiles()***********************************
   /**Method that checks files in .TrashCan against requested files to be restored. 
    *        If there is a match then that file is restored.
    * @param array that contains list of files to be restored.
    * @return null if there is no files in subdirectory. 
    * @throws IOException 
    */
   private static void restoreFiles(ArrayList<String> array) throws IOException
   {
      File trashCanSubDir = getTrashCanSubDirectory();
      //obtain files in .TrashCan/Owner 
      File[] trashFiles = trashCanSubDir.listFiles(); 
      //convert files to strings 
      ArrayList<String> absFilePaths = getTrashFilesPath(trashFiles);
      boolean found;
      //check if file exists and that there are no duplicates; then restore 
      for(int i = 0; i < array.size(); i++)
      {
         //check if user passed absolute path or just file name
         if(checkAbsolutePath(array.get(i)))
         {
            //check if absolute file path exists in .TrashCan
            found = findAndRestoreFileAP(array.get(i), absFilePaths);
            if(!found)
               System.err.println("File " + array.get(i) + " not recovered.");
         }
         else
         {
            //check if file exists in .TrashCan
            found = findAndRestoreFile(array.get(i), absFilePaths);
            if(!found)
               System.err.println("File " + array.get(i) + " not recovered.");
         }
               
      }

   }
   
   //******************************getTrashFilesPath()******************************
   /**Method that obtains all the files the user has in the .TrashCan
    * @param trashFiles array list if Files 
    * @return String array of absolute path to files in .TrashCan
    */
   private static ArrayList<String> getTrashFilesPath(File[] trashFiles)
   {
      //array of absolute paths to files will be returned
      ArrayList<String> trashFilesPath = new ArrayList<String>();
      for(int i = 0; i < trashFiles.length; i++)
      {
         //obtain absolute path to current zipped file
         String absfile = trashFiles[i].toString();
         //obtain only the zipped file name
         int index = absfile.indexOf("@");
         String file = absfile.substring(index, absfile.length());
         //convert zipped file name to original path to file
         String absfilePath = getAbsFilePath(file);
         trashFilesPath.add(absfilePath);
      }
      
      return trashFilesPath;   
   }
   
   //******************************getAbsFilePath()*********************************
   /**Method that obtains absolute path to deleted files in .TrashCan/OwnerSubdir
    * @param file is the file to be converted 
    * @return converted version of the absolute path to file in String form. 
    */
   private static String getAbsFilePath(String file)
   {
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      //convert to absolute path 
      String newFile = file.replaceAll("@", fileSeparator);
      
      return newFile;
   }
   
   //******************************checkAbsolutePath()******************************
   /**Method checks if user entered absolute path to old file
    * @param file that user wishes to restore
    * @return true if user used any delimiters
    */
   private static boolean checkAbsolutePath(String file)
   {
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      return file.contains(fileSeparator);     
      
   }
   
   //******************************getDestinationDirPath()**************************
   /**Method used to help find out if old directory of deleted file still exists
    * @param deletedFile is the file whose directly we wish to check 
    * @return string version of absolute path to directory of the file
    */
   private static String getDestinationDirPath(String deletedFile)
   {
      //remove file from path
      int index = deletedFile.indexOf("@");
      String dir = deletedFile.substring(index, deletedFile.length());
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      //restore dir based on system delimiters
      dir = dir.replaceAll("@", fileSeparator);
      index = dir.lastIndexOf(fileSeparator);
      dir = dir.substring(0, index+1);
      //return path to directory 
      return dir;
   }
   
   //******************************findAndRestoreFile()*****************************
   /**Method that compares user input of file name with files in .TrashCan.
    *        If one instance of file is found then it is restored.
    * @param file is the file user wants to restore
    * @param directory is the String array list of names of all deleted files 
    * @return true if file was found 
    * @throws IOException 
    */
   private static boolean findAndRestoreFile(String file, ArrayList<String> dir) 
   throws IOException
   {
      //count if duplicate files exist 
      int index = -1;
      int total = 0;
      for(int i = 0; i < dir.size(); i++)
      {
         if(dir.get(i).contains(file))
         {
            total++;
            index = i;
         }
      }
      
      //prompt user if they need to provide more specific details about file
      if(total > 1)
         System.err.println("Multiple files found with name " + file);
      else if(total == 1) 
      {
         //check that directory exists 
         if(checkDirectoryExists(dir.get(index)))
         {
            recoverFile(dir.get(index));
            return true;
         }
         else
         {
            //let user know that cannot recover file
            System.err.println("Cannot recover " + file + 
                              " directory does not exist");
            return false;
         }
      }

      return false;
   }
   
   
   //******************************findAndRestoreFileAP()***************************
   /**Method that compares user input of absolute file path with files in .TrashCan.
    *        If file is found then it is restored.  
    * @param file is the file user wants to restore
    * @param directory is the String array list of names of all deleted files 
    * @return true if file was found 
    * @throws IOException 
    */
   private static boolean findAndRestoreFileAP(String file, ArrayList<String> dir)
   throws IOException
   {
      for(int i = 0; i < dir.size(); i++)
         if(dir.get(i).equals(file + ".zip"))
         {
            //check that directory exists
            if(checkDirectoryExists(dir.get(i)))
            {
               recoverFile(dir.get(i));
               return true;
            }
            else
            {
               //let user know that cannot recover file
               System.err.println("Cannot recover " + file + 
                                " directory does not exist");
            }
         }
         
      return false;
   }
   
   //******************************checkDirectoryExists()***************************
   /**Method that checks if directory that file will be restored to exists.
    * @param directory is the directory into which the file will go.
    * @return true if directory exists
    */
   private static boolean checkDirectoryExists(String directory)
   {
      //get file separator
      String fileSeparator = System.getProperty("file.separator");
      //remove file from path
      int index = directory.lastIndexOf(fileSeparator);
      String dir = directory.substring(0, index);
      //check if this directory exists 
      File f = new File(dir);
    
      return f.isDirectory();
   }

   //******************************recoverFile()************************************
   /**Method that unzips the file that user wishes to un-delete  
    * @param oldFilePath this is the old file
    * @throws IOException
    */
   private static void recoverFile(String oldFilePath) throws IOException
   {
      //unzip file
      String zipedFile = getPathToZippedFile(oldFilePath);
      Zip.unzip(zipedFile);
      //cleanup by moving file to original directory 
      moveFile(zipedFile);
   }
   
   //******************************getPathToZippedFile()****************************
   /**Method used to obtain absolute path to zipped file in .TrashCan
    * @param file is the target file whose absolute path we want to obtain
    * @return absolute path to zipped file
    */
   private static String getPathToZippedFile(String file)
   {
      //get file separator
      String delim = System.getProperty("file.separator");
      String zFile = file.replaceAll(delim, "@");
  
      //get user 
      String user = System.getProperty("user.name");
      
      //get user's home directory
      String userHome = System.getProperty("user.home");
      
      //create destination file in .TrashCan
      String path = userHome + delim +".TrashCan" + delim + user +
                           delim + zFile;
      return path;
   }
   
   //******************************moveFile()***************************************
   /**Method that restores file back into original directory with proper name
    * @param file is the file to be restored to its original directory
    */
   private static void moveFile(String file)
   {
      //get destination directory 
      String destination  = getDestinationDirPath(file);
      
      String oldFile = restoreFileName(file);
      //move and rename file 
      int index = file.lastIndexOf(".zip");
      String temp = file.substring(0, index);
      File trashFile = new File(temp);
      File original = new File(destination + oldFile);
      trashFile.renameTo(original);
     
      //delete zip file
      File zip = new File(file);
      zip.delete();

   }
   
   //******************************restoreFileName()********************************
   /**Method that restores original name of the file 
    * @param f is the file whose name is to be restored 
    * @return original name of the file 
    */
   private static String restoreFileName(String f)
   {
      //extract original file name by modifying the string
      int index = f.lastIndexOf(".");
      String file = f.substring(0, index);
      index = file.lastIndexOf("@");
      file = file.substring(index+1, file.length());
      //return original file name
      return file;
   }
   
}
