
public class TestString
{
   public static void main(String[] args)
   {
      String hello = "0123/567/9";
      int index = hello.lastIndexOf("7/");
      String sub = hello.substring(0, index);
      System.out.println(hello);
      System.out.println(sub);
            
   }
}
