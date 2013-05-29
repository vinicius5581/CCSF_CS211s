/**Name: Victor Malchikov
 * File: BrushChangeListener.java
 */

package hw.button;

import hw.CanvasSpace;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**Class that listens for user to select the Brush button. Allows user to create
 * 	     a new brush.
 */
public class BrushChangeListener extends BasicListener
{
	private CanvasSpace drawingArea;
	
	//****************************BrushChangeListener()*****************************
	public BrushChangeListener(JPanel container, CanvasSpace drawingArea)
	{
		super(container, drawingArea);
		this.drawingArea = drawingArea;
	}
	
	//*****************************actionPerformed()********************************
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//set following to false
		drawingArea.freeDrawControl(false);
		drawingArea.eraserControl(false);
		drawingArea.circleControl(false);
		drawingArea.rectControl(false);
		drawingArea.lineControl(false);
		//turn bursh ON
		drawingArea.brushControl(true); 
		//ask user to create brush via input 
		String brush = JOptionPane.showInputDialog("Create your own brush!");
		drawingArea.setBrush(brush);
		//ensure that cursor is reset to default 
		Cursor cursor = Cursor.getDefaultCursor();
		drawingArea.setCursor(cursor);

	} 
}
