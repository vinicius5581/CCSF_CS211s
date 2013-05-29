import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Copy {

	public static void main(String[] args) {
		
		List<Number> n = Arrays.<Number>asList(2, 3.14, 4);
		List<Integer> i = Arrays.asList(1,2,3);
		Collections.copy(n,i);
		
		String ver = System.getProperty("java.version", "6.1");
		System.out.println(ver);
		//ver = ver.substring(2, 3);
		//System.out.println(ver);
		Character c = ver.charAt(2);
		System.out.println(c);
		
		int a = 9;
		int b = 5;
		swap(a,b);
		System.out.println(a + " " + b);
	}
	
	private static void swap(Integer a, Integer b)
	{
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
	
}
