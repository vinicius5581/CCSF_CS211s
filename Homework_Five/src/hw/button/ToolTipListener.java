package hw.button;

import java.awt.event.ActionEvent;

import hw.CanvasSpace;
import hw.DrawingBoardButtonContainer;

import javax.swing.JPanel;

public class ToolTipListener extends BasicListener  
{
	boolean toolTip = true;
	private CanvasSpace canvas;
	
	public ToolTipListener(JPanel container, CanvasSpace drawingArea) 
	{
		super(container, drawingArea);
		canvas = drawingArea;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(toolTip)
		{
			
			toolTip = false;
			canvas.get
		
		}
		else
		{
		
			toolTip = true;
		
		}
		
	}

}
