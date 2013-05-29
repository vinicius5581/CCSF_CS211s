/**Name: Victor Malchikov
 * File: LineSegments.java
 */
package hw.shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**Class allows user to free draw any shape they want.*/
public class LineSegments extends ShapeBuilder
{

	private Color color; //color of pen
	private ArrayList<Point> points = new ArrayList<>(); //store drawn points 
	private int penSize; //size of the pen stroke 
	
	//***************************LineSegments()*************************************
	public LineSegments(Color c, int penSize)
	{
		color =c;
		this.penSize = penSize;
	}
	
	//*************************getColor()******************************************
	public Color getColor()
	{
		return color;
	}
	
	//*************************drawShape()*****************************************
	@Override
	public void drawShape(Graphics2D g)
	{
		//LineSegments know how to "draw themselves" based on points stored 
		g.setColor(color); //set color 
		g.setStroke(new BasicStroke(penSize)); //set pen size
		//draw anything that user drew via free-draw 
		for(int i = 1; i < points.size(); i++)
		{
			int x1 = points.get(i-1).x;
			int y1 = points.get(i-1).y;
			int x2 = points.get(i).x;
			int y2 = points.get(i).y;
			//draw what user free-drew 
			g.drawLine(x1, y1, x2, y2);
			
		}
	}
	
	//************************************getPoint()*******************************
	public void getPoint(Point xy)
	{
		points.add(xy);
	}


}
