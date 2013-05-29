/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: ColorAmountDisplay.java 
*/

import java.awt.Graphics;

public class ColorAmountDisplay 
{
	//*************************ColorAmountDisplay()*********************************
	public ColorAmountDisplay(Graphics g, int red, int green, int blue, 
			                  DisplayType format)
	{
		//obtain string form of red/green/blue values based on scrollbars 	
		String r = getType(format, red);
		String gr = getType(format, green);
		String b = getType(format, blue);
		
		//draw red
		g.drawString("RED", 40, 235);
		g.drawString(r, 40, 250);
		//draw green
		g.drawString("GREEN", 165, 235);
		g.drawString(gr, 165, 250);
		//draw blue
		g.drawString("BLUE", 300, 235);
		g.drawString(b, 300, 250);
	}
	
	//*************************getType()********************************************
	private String getType(DisplayType format, int color)
	{
		//convert number to string based on which button is selected
		String type = format.toString();
		if(type.equals("Decimal"))
		{
			return Integer.toString(color);
		}
		if(type.equals("Octal"))
		{
			return Integer.toOctalString(color);
		}
		if(type.equals("Binary"))
		{
			return Integer.toBinaryString(color);
		}
		if(type.equals("Hex"))
		{
			return Integer.toHexString(color);
		}
		return null;
		
	}
	
}
