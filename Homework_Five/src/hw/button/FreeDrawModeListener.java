/**Name: Victor Malchikov
 * File: FreeDrawModeListener.java
 */
package hw.button;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import hw.CanvasSpace;
import javax.swing.JPanel;

/**Class that allows user to "free-draw" shapes based on cursor location. */
public class FreeDrawModeListener extends BasicListener
{
	private CanvasSpace drawingArea;
	
	//********************************FreeDrawModeListener()************************
	public FreeDrawModeListener(JPanel container, CanvasSpace drawingArea) 
	{
		super(container, drawingArea);
		this.drawingArea = drawingArea;
	}
	
	//*********************************actionPerformed()***************************
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//ensure that only free-draw mode is on
		drawingArea.freeDrawControl(true); //set freeDrawMode true to enable it
		drawingArea.eraserControl(false);
		drawingArea.circleControl(false);
		drawingArea.rectControl(false);
		drawingArea.lineControl(false);
		drawingArea.brushControl(false);

		//get default cursor 
		Cursor cursor = Cursor.getDefaultCursor();
		drawingArea.setCursor(cursor);
	}

}
