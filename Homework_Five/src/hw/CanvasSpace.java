/**Name: Victor Malchikov
 * File: CanvasSpace.java
 */
package hw;

import hw.shape.BasicCircle;
import hw.shape.BasicLine;
import hw.shape.BasicRectangle;
import hw.shape.BrushSegments;
import hw.shape.LineSegments;
import hw.shape.ShapeBuilder;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;

public class CanvasSpace extends Canvas implements Serializable
{
	//container is what canvas is added to
	JFrame container;
	//sb contains shapes that the user drew on the canvas 
	private List<ShapeBuilder> sb = new LinkedList<>();
	//penColor is the current color user is drawing with (default is black)
	private Color penColor = Color.black;
	//eraserColor is the color of the eraser (always set to white)
	private final Color ERASER_COLOR = Color.white;
	
	//lineSegments is a class that draws line segments created by the user 
	//freeDrawMode is mode where user can draw anything they wish 
	private LineSegments lineSegments;
	private boolean freeDrawMode = false;
	
	//BasicLine basicLine - saves drawn line object 
	private BasicLine basicLine;
	private boolean drawLine = false;
	
	//BasicCircle basicCircle - saves drawn circle object
	private BasicCircle basicCircle;
	private boolean drawCircle = false;
	
	//BasicRectangle basicRect - saves drawn rectangle object
	private BasicRectangle basicRectangle;
	private boolean drawRect = false;

	//BrushSegments brushSegments - saves object of what user draws using brush
	private BrushSegments brushSegments;
	private String brush;
	private boolean drawWithBrush = false;
	
	//eraser is a tool that user can use to remove mistakes (default is off)
	private boolean eraser = false;
	
	//**************************CanvasSpace()***************************************
	//constructor that creates canvas space with knowledge of it's container 
	public CanvasSpace(JFrame container)
	{
		this.container = container;
		//create object of DrawListener class that will notify us of events
		DrawListener dl = new DrawListener(this);

		addMouseListener(dl); //add mouse listeners to listen for user's actions
		addMouseMotionListener(dl);
	}
	
	//*************************getDrawingAreaContainer()***************************
	//default constructor 
	public JFrame getDrawingAreaContainer()
	{
		return container;
	}
	
	//************************paint()***********************************************
	public void paint(Graphics g)
	{
	}
	
	//************************getListOfShapes()*************************************
	//method used for Saving a file that contains a List with drawn shapes
	public List<ShapeBuilder> getListOfShapes()
	{
		return sb;
	}
	
	//************************setListOfShapes()*************************************
	//method that is used for Loading a file that contains a List with drawn shapes
	public void setListOfShapes(List<ShapeBuilder> shapes)
	{
		sb = shapes;
	}
	
	//*************************repaint()********************************************
	//used to update canvas based on user's actions 
	public void repaint()
	{
		for(int i = 0; i < sb.size(); i++)
		{
			sb.get(i).drawShape(getGraphicsTool());	//calls method shared by shapes
		}
		
	}
	
	//***************************getCanvasSpace()***********************************
	//method that returns CanvasSpace 
	public CanvasSpace getCanvasSpace()
	{
		return this;
	}
	
	//***************************getGrpahicsTool()**********************************
	//set size of the drawing pen
	public Graphics2D getGraphicsTool() 
	{
		Graphics g = getGraphics();
		return (Graphics2D)g;
	}

	//**************************clear()********************************************
	//clear method
	public void clear()
	{
		//remove all saved data points from arrayPC
		sb.clear();
	
		//paint over entire canvas white rectangle (size of the canvas)
		Graphics g = getGraphics();
		g.setColor(Color.white);
		int width = getWidth();
		int height = getHeight();
		//get size of canvas and paint everything white
		g.fillRect(0, 0, width, height); 
		//update canvas
		repaint();
	}
	
	//****************************getPenColor()*************************************
	//get pen color
	public Color getPenColor()
	{
		return penColor;
	}
	
	//*****************************setPenColor()************************************
	public void setPenColor(Color newColor)
	{
		penColor = newColor;
	}
	
	//*****************************freeDrawControl()********************************
	//set free drawing mode on/off
	public void freeDrawControl(boolean setControl)
	{
		freeDrawMode= setControl;
	}
	
	//*****************************eraserControl()**********************************
	//set eraser to be on/off
	public void eraserControl(boolean setControl)
	{
		eraser = setControl;
	}
	
	//****************************circleControl()***********************************
	public void circleControl(boolean setControl)
	{
		drawCircle = setControl;
	}
	
	//***************************rectControl()**************************************
	public void rectControl(boolean setControl)
	{
		drawRect = setControl;
	}
	
	//**************************lineControl()***************************************
	public void lineControl(boolean setControl)
	{
		drawLine = setControl;
	}
	
	//**************************brushControl()**************************************
	public void brushControl(boolean setControl)
	{
		drawWithBrush = setControl;
	}
	
	//*************************setBrush()*******************************************
	public void setBrush(String brush)
	{
		this.brush = brush;
		
	}
	
     //*******************************DrawListener- Class***************************
	//private class that helps track and respond to user's behavior 
	private class DrawListener extends MouseAdapter implements Serializable
	{
		private CanvasSpace drawingArea;
		
		//*************************DrawListener()***********************************
		public DrawListener(CanvasSpace drawingArea)
		{
			this.drawingArea = drawingArea;
		}
		
		//*************************mouseClicked()***********************************
		@Override
		public void mouseClicked(MouseEvent e)
		{
			//System.out.println(e.getButton() + " " + MouseEvent.BUTTON3);
			if(e.getButton() == MouseEvent.BUTTON3)
			{
				//System.out.println("I am in here");
				if(!sb.isEmpty())
					sb.remove(sb.size()-1);
				drawingArea.update(getGraphicsTool());
				repaint();
			}
			
		
		}
		
		//***************************mousePressed()*********************************
		@Override
		public void mousePressed(MouseEvent e)
		{
			//user selected free-draw or eraser 
			if((freeDrawMode) || ( eraser))
			{
				//store points that user is erasing 
				if(eraser && (e.getButton() == MouseEvent.BUTTON1))
				{
					lineSegments = new LineSegments(ERASER_COLOR, 8);
					lineSegments.getPoint(e.getPoint());
					lineSegments.getPoint(e.getPoint());
					sb.add(lineSegments); //add erased lines to container 
				}
				//store points user is erasing 
				if(freeDrawMode && (e.getButton() == MouseEvent.BUTTON1))
				{
					lineSegments = new LineSegments(penColor, 3);
					lineSegments.getPoint(e.getPoint());
					lineSegments.getPoint(e.getPoint());
					sb.add(lineSegments); //add lines to container 
				}

			}

			//user wants to draw with brush
			if(drawWithBrush && (e.getButton() == MouseEvent.BUTTON1))
			{
				brushSegments = new BrushSegments(brush, penColor, 3);
				brushSegments.getPoint(e.getPoint());
				sb.add(brushSegments); //add brush objects to container 
	
			}
			
			//user wants to draw basic lines 
			if(drawLine && (e.getButton() == MouseEvent.BUTTON1))
			{
		
				basicLine = new BasicLine(penColor, 3);
				sb.add(basicLine); //add basic line to container 
				basicLine.getStartingPoint(e.getPoint()); //get starting point 
				basicLine.getEndPoint(e.getPoint()); //get ending point 
				
			}
			
			//user wants to draw basic circles 
			if(drawCircle && (e.getButton() == MouseEvent.BUTTON1))
			{
				basicCircle = new BasicCircle(penColor, 3);
				sb.add(basicCircle); //add shape to container 
				basicCircle.getStartingPoint(e.getPoint());
				basicCircle.getEndPoint(e.getPoint());
			}
			
			//user wants to draw basic rectangle 
			if(drawRect && (e.getButton() == MouseEvent.BUTTON1))
			{
				basicRectangle = new BasicRectangle(penColor, 3);
				sb.add(basicRectangle); //add shape to container 
				basicRectangle.getStartingPoint(e.getPoint());
				basicRectangle.getEndPoint(e.getPoint());
			}
			//repaint to display user's actions 
			repaint();
		}
	
		//*************************mouseDragged()***********************************
		@Override
		public void mouseDragged(MouseEvent e)
		{
			//store points for eraser or free-draw 
			if((freeDrawMode) || (eraser))
			{
				//store point + color based on mouse position 
				lineSegments.getPoint(e.getPoint());
			}
			
			//store points for brush drawing 
			if(drawWithBrush)
			{
				brushSegments.getPoint(e.getPoint());
			}
			
			//store end point of line 
			if(drawLine)
			{
				basicLine.getEndPoint(e.getPoint());
				drawingArea.update(getGraphicsTool());
			}
			
			//store end point of circle 
			if(drawCircle)
			{
				basicCircle.getEndPoint(e.getPoint());
				drawingArea.update(getGraphicsTool());
			}
			
			//store end point of rectangle 
			if(drawRect)
			{
				basicRectangle.getEndPoint(e.getPoint());
				drawingArea.update(getGraphicsTool());
			}
			//update to show user what they are drawing / drew 
			repaint();
		}


	}

}
