/**Name: Victor Malchikov
 * File: BrushSegments.java
 */
package hw.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**Class that allows user to change / create own brush. */
public class BrushSegments extends ShapeBuilder
{
	private ArrayList<Point> points = new ArrayList<>(); //store drawn shape
	private Color brushColor; //color of brush
	private String brushString; //string representing brush
	private int penSize; //size of brush text 
 	
	//******************************BrushSegments()*********************************
	public BrushSegments(String brushString, Color brushColor, int penSize)
	{
		this.brushColor = brushColor;
		this.brushString = brushString;
		this.penSize = penSize;
	}
	
	//*********************************getPoint()**********************************
	//add points to where the String should be drawn
	public void getPoint(Point xy)
	{
		points.add(xy);
	}
	
	//********************************drawShape()*********************************
	@Override
	public void drawShape(Graphics2D g) 
	{
		g.setColor(brushColor); //set brush color 
		g.setStroke(new BasicStroke(penSize)); //set brush size
		for(int i = 0; i < points.size(); i++)
		{   //draw brush
			g.drawString(brushString, points.get(i).x, points.get(i).y);
		}
		
	}


}
