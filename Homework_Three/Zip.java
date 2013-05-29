/*
 
 Author: Abbas Moghtanei 
 Date  : 09/14/11
 Program Name: Zip.java
*/
 
import java.util.zip.*;
import java.io.*;
 
class Zip
{
//********************************unzip()*********************************
   public static void unzip(String zipfile)
   {
      try
      {
         String inFilename = zipfile;
         ZipInputStream zis = new ZipInputStream(new FileInputStream(
                                                 inFilename));
         ZipEntry ze = zis.getNextEntry();
         String outFilename =
               zipfile.substring(0, zipfile.lastIndexOf(".zip"));

         FileOutputStream os = new FileOutputStream(outFilename);

         byte buf[] = new byte[1024];
         int len;

         while((len = zis.read(buf)) > 0) os.write(buf, 0, len);

         os.close();
         zis.close();
      }catch(IOException e) {}
   }
//*********************************zip()**********************************
   public static void zip(String fname)
   {
      byte buf[] = new byte[1024];
      try
      {
         String outFilename = fname + ".zip";
         ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
                                                   outFilename));
         FileInputStream fis = new FileInputStream(fname);
         zos.putNextEntry(new ZipEntry(fname));

         int len;
         while((len = fis.read(buf)) > 0) zos.write(buf, 0, len);

         zos.close();
         fis.close();
      }catch(IOException e){}
   }
}
