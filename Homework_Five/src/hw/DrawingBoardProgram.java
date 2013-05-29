/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework: 5
 * File: DrawingBoardProgram.java
 * Info: Drawing application that allows the user to free draw, create basic shapes,
 *       change brush, change colors, erase, clear, load/save. Other features 
 *       include buttons that show tool-tips. User can erase with Right-Click a 
 *       previously drawn shape.   
*/

package hw;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;


public class DrawingBoardProgram implements Serializable
{

	public static void main(String[] args)
	{
		try {
			SwingUtilities.invokeAndWait(new Runnable() //create thread for Swing
			{
				public void run() //implement run
				{
					new DrawingBoardSetup();
				}
			});
		} 
		catch (InvocationTargetException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
