/**Name: Victor Malchikov
 * File: ColorChangeListener.java
 */

package hw.button;

import hw.CanvasSpace;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**Class that allows user to select from a large veriety of colors to draw with. */
public class ColorChangeListener extends BasicListener 
{
	private CanvasSpace drawingArea;
	
	//*******************************ColorChangeListener()**************************
	public ColorChangeListener(JPanel container, CanvasSpace drawingArea)
	{
		super(container, drawingArea);
		this.drawingArea = drawingArea; 
	}
	
	//******************************actionPerformed()*******************************
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//obtain a new color via JColorChooser
		Color c = JColorChooser.showDialog(null, "Color Selection", Color.black);
		//set penColor to be new selected color 
		drawingArea.setPenColor(c);
		//ensure default cursor is used 
		Cursor cursor = Cursor.getDefaultCursor();
		drawingArea.setCursor(cursor);
	}
}
