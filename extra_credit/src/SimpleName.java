import java.util.HashMap;


public class SimpleName 
{
	public static void main(String args[])
	{
		String a = "hello";
		HashMap<String, Object> d = new HashMap<>();
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass().getSimpleName());
		System.out.println(d.getClass().getName());
		System.out.println(d.getClass().getSimpleName());
		
		Class<?> c = String.class;
		System.out.println(c);
		//Class cc = "a".class; error
		System.out.println(String.class.getName());
		System.out.println(Integer.TYPE.isPrimitive());
		
	}
}
