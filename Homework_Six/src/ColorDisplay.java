/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: ColorDisplay.java 
*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ColorDisplay extends Canvas 
{
	//coordinates to draw diamons
	private int[] xCoords; 
	private int[] yCoords; 
	//four diamonds to be displayed
	private DiamondShape ds1;
	private DiamondShape ds2;
	private DiamondShape ds3;
	private DiamondShape bigDiamond;
	//colrAmount contains visual number display of color values
	private ColorAmountDisplay colorAmount;
	//colors for diamonds
	private int redColor = 0;
	private int blueColor = 0;
	private int greenColor = 0;
	//displayType properly sets up numberic display 
	private DisplayType format; 
	
	//*********************************ColorDisplay()*******************************
	public ColorDisplay()
	{
		setPreferredSize(new Dimension(400,500));
		format = new DisplayType();
	}
	
	//*********************************paint()**************************************
	public void paint(Graphics g)
	{
		setup(getGraphics());
		colorAmount = new ColorAmountDisplay(getGraphics(), redColor, 
				                             greenColor, blueColor, format);
	}
	
	//*********************************getColorAmountDisplay()**********************
	public ColorAmountDisplay getColorAmountDisplay()
	{
		return colorAmount;
	}
	
	//*********************************setRedColor()********************************
	//update Color amounts 
	public void setRedColor(int amount)
	{
		redColor = amount; 
		repaint();
	}
	
	//*********************************setGreenColor()******************************
	public void setGreenColor(int amount)
	{
		greenColor = amount;
		repaint();
	}
	
	//*********************************setBlueColor()*******************************
	public void setBlueColor(int amount)
	{
		blueColor = amount;
		repaint();
	}
	
	//*********************************setType()************************************
	//obtains type of numeric display user wants to see and uses format to properly
	//setup display
	public void setType(String type)
	{
		if(type.equals("Decimal"))
			format.setDecimalFormat();
		if(type.equals("Octal"))
			format.setOctalFormat();
		if(type.equals("Binary"))
			format.setBinaryFormat();
		if(type.equals("Hex"))
			format.setHexFormat();
		
		repaint();
	}
	
	//*********************************setup()**************************************
	//displays 4 diamonds + updates display of 4 diamonds when color amount changes
	public void setup(Graphics g)
	{
		//moveFactor determines how far apart diamonds should be
		int moveFactor = 0;
		for(int i = 0; i < 3; i++)
		{
			getXandYCoords(moveFactor);
			if(i == 0)
			{
				ds1 = new DiamondShape(4, xCoords, yCoords, g,
						               new Color(redColor, 0, 0));
			}
			if(i == 1)
			{
				ds2 = new DiamondShape(4, xCoords, yCoords, g, 
						               new Color(0, greenColor, 0));
			}
			if(i == 2)
			{
				ds3 = new DiamondShape(4, xCoords, yCoords, g,
						               new Color(0, 0, blueColor));
			}
			//update move factor
			moveFactor += 130;
		}
		//setup 4th diamond 
		setupMainDiamond(g);
	}
	
	//*********************************getXandYCoords()*****************************
	public void getXandYCoords(int moveFactor)
	{
		xCoords = new int[4];
		yCoords = new int[4];
		//setup diamond's x coordinates 
		xCoords[0] = 50 +moveFactor;
		xCoords[1] = 100 +moveFactor;
		xCoords[2] = 50 +moveFactor;
		xCoords[3] = 0 +moveFactor;
		//setup diamond's y coordinates 
		yCoords[0] = 10;
		yCoords[1] = 110;
		yCoords[2] = 210;
		yCoords[3] = 110;

	}
	
	//*********************************setupMainDiamond()***************************
	private void setupMainDiamond(Graphics g)
	{
		xCoords = new int[4];
		yCoords = new int[4];
		//setup x coordinates
		xCoords[0] = 180;
		xCoords[1] = 275;
		xCoords[2] = 180;
		xCoords[3] = 85;
		//setup y coordinates
		yCoords[0] = 300;
		yCoords[1] = 400;
		yCoords[2] = 500;
		yCoords[3] = 400;
		
		bigDiamond = new DiamondShape(4, xCoords, yCoords, g,
				                      new Color(redColor, greenColor, blueColor));

	}
}
