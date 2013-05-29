/**Name: Victor Malchikov
 * File: BasicCircle.java
 */
package hw.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**Class allows user to draw a circle.  */
public class BasicCircle extends ShapeBuilder 
{
	private Point startingPoint; //initial point user selected in canvas 
	private Point endPoint; //end point where user is satisfied with circle 
	private Color circleColor; //color of cirlce 
	private int penSize; //size of pen

	//constructor
	//*****************************BasicCircle()**********************************
	public BasicCircle(Color circleColor, int size)
	{
		this.circleColor = circleColor;
		penSize = size;
	}

	//*****************************getEndPoint()**********************************
	public void getEndPoint(Point xy)
	{
		endPoint = xy;
	}
	
	//*****************************getStartingPoint()*****************************
	public void getStartingPoint(Point xy)
	{
		startingPoint = xy;
	}
	
	//*****************************drawShape()************************************
	@Override
	public void drawShape(Graphics2D g)
	{
		g.setColor(circleColor); //set color of pen 
		g.setStroke(new BasicStroke(penSize)); //set size of circle 
		int x1 = startingPoint.x;
		int y1 = startingPoint.y;
		int x2 = endPoint.x;
		int y2 = endPoint.y;
		//draw shape 
		g.drawOval(x1, y1, x2, y2);
		
	}

}
