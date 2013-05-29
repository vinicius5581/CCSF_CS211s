/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * Homework: 6
 * File: PaletteFrame.java 
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PaletteFrame extends JFrame 
{
	//******************************PaletteFrame()**********************************
	public PaletteFrame()
	{
		setTitle("Color Mix"); //title
		setSize(800,700); //frame size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setLayout(new BorderLayout());
		
		setupPalette(); //adds canvas to layout
		//pack();
		setVisible(true);
		
	}
	
	//******************************setupPalette()**********************************
	public void setupPalette()
	{
		//ColorDisplay is main program that draws / displays shapes and changes
		ColorDisplay canvas = new ColorDisplay();
		//CanvasContainer allows creation of boarder around canvas
		JPanel CanvasContainer = new JPanel();
		CanvasContainer.add(canvas);
		CanvasContainer.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		add(CanvasContainer);
		
		//add to SOUTH of Boarder (3 scroll bars) 
		JPanel south = new ScrollBarPanel(canvas);
		//add border 
		south.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Dimension size = new Dimension(200, 150);
		south.setPreferredSize(size);
		south.setBackground(Color.yellow);
		add(south, BorderLayout.SOUTH);
		
		//add to EAST of Boarder (Radio Buttons)
		JPanel east = new ButtonPanel(canvas);
		//add border
		east.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		east.setPreferredSize(new Dimension(120,100));
		add(east, BorderLayout.EAST);
	}
}
