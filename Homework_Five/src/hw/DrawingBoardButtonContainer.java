/**Name: Victor Malchikov
 * File: DrawingBoardButtonContainer.java 
 */
package hw;

import hw.button.BasicButton;
import hw.button.BrushChangeListener;
import hw.button.ClearCanvasListener;
import hw.button.ColorChangeListener;
import hw.button.EraserListener;
import hw.button.FreeDrawModeListener;
import hw.button.LoadListener;
import hw.button.SaveListener;
import hw.button.ShapeListener;
import java.io.Serializable;
import javax.swing.JPanel;

/**Class that stores / adds all the buttons to the application. */
public class DrawingBoardButtonContainer extends JPanel implements Serializable 
{
	private CanvasSpace canvas;
	
	//*******************************DrawingBoardButtonContainer()******************
	public DrawingBoardButtonContainer(CanvasSpace drawingArea)
	{
		canvas = drawingArea;
		//basic save button
		BasicButton save = new BasicButton("Save", this, 
				                           new SaveListener(this, canvas));
		save.setToolTip("Save your drawing.");
		//basic load button
		BasicButton load = new BasicButton("Load", this, 
				                           new LoadListener(this, canvas));
		load.setToolTip("Load saved drawing.");
		//basic color button
		BasicButton color = new BasicButton("Colors", this, 
				                           new ColorChangeListener(this, canvas));
		color.setToolTip("Select a color to draw with.");
		//basic brush button
		BasicButton brush = new BasicButton("Brushes", this, 
				                           new BrushChangeListener(this, canvas));
		brush.setToolTip("Select a new brush.");
		//basic shapes
		BasicButton shapes = new BasicButton("Basic Shapes", this, 
				                           new ShapeListener(this, canvas));
		shapes.setToolTip("Draw a basic shape: circle, line, rectangle");
		//basic erase button
		BasicButton eraser = new BasicButton("Eraser", this, 
				                           new EraserListener(this, canvas));
		eraser.setToolTip("Use this to erase a mistake.");
		//basic clear button
		BasicButton clear = new BasicButton("Clear", this, 
				                          new ClearCanvasListener(this, canvas));
		clear.setToolTip("Clear the entire canvas");
		//basic free drawing mode button
		BasicButton freeMode = new BasicButton("Hand Draw", this, 
				                          new FreeDrawModeListener(this, canvas));
		freeMode.setToolTip("Free draw on canvas.");
		
	}
	

}
