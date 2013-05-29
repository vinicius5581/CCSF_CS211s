/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework: 6
 * File: ColorMixterProgram.java
 * Info: This program creates an application that display 4 diamond shapes. Three 
 *       shapes are used to for mixing primary colors. The fourth shape displays
 *       the result when different values of primary colors are mixed together.
 *       User can see numeric values in Decimal, Binary, Octal, or Hex form.
*/

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

public class ColorMixerProgram
{
	public static void main(String[] args)
	{
		try {
			SwingUtilities.invokeAndWait(new Runnable() //create and run thread
			{
				public void run()
				{
					new PaletteFrame(); //PaletteFrame is main container (Frame)
				}
			});
		} 
		catch (InvocationTargetException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
