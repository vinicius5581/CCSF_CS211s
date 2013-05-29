/**Name: Victor Malchikov
 * File: ClearCanvasListener.java
 */
package hw.button;

import hw.CanvasSpace;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**Class that listens for user to select the Clear button. Allows user to clear
 *       drawing area of all drawn objects. 
 */
public class ClearCanvasListener extends BasicListener
{
	private CanvasSpace drawingArea;
	
	//****************************ClearCanvasListener()*****************************
	public ClearCanvasListener(JPanel container, CanvasSpace drawingArea)
	{
		super(container, drawingArea);
		this.drawingArea = drawingArea;
	}
	
	//***************************actionperformed()**********************************
	@Override
	public void actionPerformed(ActionEvent e)
	{
		CanvasSpace c = drawingArea;
		//calls the clear method that sets all stored List<Shapes> object to null
		c.clear(); 
		//ensure that cursor is set to default
		Cursor cursor = Cursor.getDefaultCursor();
		drawingArea.setCursor(cursor);
	}
	

}
