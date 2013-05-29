/**Name: Victor Malchikov
 * File: BasicLine.java
 */
package hw.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**Class that allows user to draw a line */
public class BasicLine extends ShapeBuilder
{
	private Point startingPoint; //starting point of line
	private Point endPoint; //ending point of the line
	private Color lineColor; //color of line
	private int penSize; //size of line 
	
	//********************************BasicLine()*********************************
	public BasicLine(Color lineColor, int size)
	{
		this.lineColor = lineColor;
		penSize = size;	
	}
	
	//*******************************drawShape()**********************************
	@Override
	public void drawShape(Graphics2D g)
	{
		g.setColor(lineColor); //set color 
		g.setStroke(new BasicStroke(penSize)); //set size of line
		int x1 = startingPoint.x; 
		int y1 = startingPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		//draw line
		g.drawLine(x1, y1, x2, y2);
		
	}
	
	//*******************************getEndPoint()**********************************
	public void getEndPoint(Point xy)
	{
		endPoint = xy;
	}
	
	//*******************************getStartingPoint()****************************
	public void getStartingPoint(Point xy)
	{
		startingPoint = xy;
	}


}
