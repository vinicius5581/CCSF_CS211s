/**Name: Victor Malchikov
 * File: BasicRectangle.java
 */
package hw.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**Class that allows user to draw a rectangle. */
public class BasicRectangle extends ShapeBuilder
{
	private Point startingPoint; //starting point 
	private Point endPoint; //end point 
	private Color rectangleColor;  //color of rectangle 
	private int penSize; //size of rectangle's lines 
	
	//********************************BasicRectangle()******************************
	//constructor
	public BasicRectangle(Color rectangleColor, int size)
	{
		this.rectangleColor = rectangleColor;
		penSize = size;
	}
	
	//*******************************drawShape()************************************
	@Override
	public void drawShape(Graphics2D g) 
	{
		g.setColor(rectangleColor); //set color of ractangle 
		g.setStroke(new BasicStroke(penSize)); //set size of lines 
		int x1 = startingPoint.x; 
		int y1 = startingPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		//draw rectangle 
		g.drawRect(x1, y1, x2, y2);
	}
	
	//********************************getEndPoint()********************************
	public void getEndPoint(Point xy)
	{
		endPoint = xy;
	}
	
	//********************************getStartingPoint()***************************
	public void getStartingPoint(Point xy)
	{
		startingPoint = xy;
	}

}
