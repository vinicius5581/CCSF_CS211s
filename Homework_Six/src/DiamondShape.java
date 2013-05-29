/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: DiamondShape.java 
*/

import java.awt.Color;
import java.awt.Graphics;

public class DiamondShape 
{
	//***************************DiamondShape()*************************************
	public DiamondShape(int numberOfPoints, int xCoords[], int yCoords[],
			            Graphics g, Color c)
	{
		//draw diamond based on color + coords 
		g.setColor(c);
		g.fillPolygon(xCoords, yCoords, numberOfPoints);
	}
	
}
