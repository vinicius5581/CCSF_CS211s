/**Name: Victor Malchikov
 * File: ShapeListener.java
 */
package hw.button;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import hw.CanvasSpace;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**Class that allows user to draw one of three basic shapes: Circle, Line, Rectangle
 */
public class ShapeListener extends BasicListener
{
	private JPanel container;
	private CanvasSpace drawingArea;
	
	//***********************************ShapeListener()****************************
	public ShapeListener(JPanel container, CanvasSpace drawingArea)
	{
		super(container, drawingArea);
		this.container = container;
		this.drawingArea = drawingArea;
	}

	//*************************************actionPerformed()************************
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		//ensure that no other drawing option is selected / in-use 
		drawingArea.freeDrawControl(false);
		drawingArea.eraserControl(false);
		drawingArea.circleControl(false);
		drawingArea.rectControl(false);
		drawingArea.lineControl(false);
		drawingArea.brushControl(false);
		
		//prompt JOptionPane window with options of 3 basic shapes 
		Icon i = UIManager.getIcon(JOptionPane.QUESTION_MESSAGE);
		String[] shapes = { "Circle", "Line" , "Rectangle" };
		String selection = (String) JOptionPane.showInputDialog(container,
				           "Select a shape:", "Basic Shapes",
				            JOptionPane.PLAIN_MESSAGE, i, shapes, shapes[0]);
		
		//set selection to "" string if user did not pick an option to avoid error 
		if(selection == null)
			selection = "";
		
		//set drawing capability 
		switch (selection) 
		{
			case "Circle" : drawingArea.circleControl(true);
				break;
			case "Line" : drawingArea.lineControl(true);
				break;
			case "Rectangle" : drawingArea.rectControl(true);
				break;
			default : drawingArea.freeDrawControl(true);
		}
		
		//ensure that basic cursor is used
		Cursor cursor = Cursor.getDefaultCursor();
		drawingArea.setCursor(cursor);
		
	}

}
