/**Name: Victor Malchikov
 * File: EraserListener.java
 */
package hw.button;

import hw.CanvasSpace;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JPanel;

/**Class that allows user to erase what they drew on the canvas. If eraser image 
 *       exists on system then it is used. Else default look cursor is used. */
public class EraserListener extends BasicListener 
{
	private Point hotSpot = new Point(0,0); //where eraser pointer is set at
	private CanvasSpace drawingArea; //canvas with drawing 

	//constructor 
	//****************************EraserListener()**********************************
	public EraserListener(JPanel con, CanvasSpace drawingArea)
	{
		super(con, drawingArea);
		this.drawingArea = drawingArea;
	}
	
	//***************************actionPerformed()*********************************
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//ensure that other modes are turned off
		drawingArea.freeDrawControl(false);
		drawingArea.eraserControl(true); //turn eraser ON
		drawingArea.circleControl(false);
		drawingArea.rectControl(false);
		drawingArea.lineControl(false);
		drawingArea.brushControl(false);
	
		Toolkit tk = Toolkit.getDefaultToolkit(); //get toolkit to make cursor
		File eraserCheck = new File("eraser.png"); //eraser cursor img
	
		if(eraserCheck.isFile()) //check if img exists on system 
		{
			//note: if img did not exist on system then default mouse look is used
			Image eraser = tk.getImage("eraser.png");
			Cursor cursor = tk.createCustomCursor(eraser, hotSpot, "eraser");
			drawingArea.setCursor(cursor);
		}

	}
}
