/**Name: Victor Malchikov
 * File: SaveListener.java
 */
package hw.button;

import hw.CanvasSpace;
import hw.shape.ShapeBuilder;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**Class that allows user to save their drawing to their device. */
public class SaveListener extends BasicListener 
{

	private JFileChooser fc; //fileChooser allows visual navigation of system dir
	private JPanel container;
	private List<ShapeBuilder> containerOfObjects; //object to be serialized/saved
	private CanvasSpace drawingArea;
	
	//**************************SaveListner()***************************************
	public SaveListener(JPanel container, CanvasSpace area)
	{
		super(container, area);
		this.container = container;
		containerOfObjects = area.getListOfShapes(); //obtain list of drawn shapes
		drawingArea = area;
	}
	
	//*******************************actionPerformed()******************************
	//must implement activity activated via button click
	public void actionPerformed(ActionEvent e)
	{
		//default starting area is user's home directory
		fc = new JFileChooser(System.getProperty("user.home"));
		
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int returnValue = fc.showSaveDialog(null);
		
		//make sure that user selected save button
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			//obtain name of file by user 
			File file = fc.getSelectedFile();
			//get absolute path 
			String fileName = file.getAbsolutePath();
			
			//make sure that there is a filename
			if(fc.getSelectedFile() != null)
			{
		
				try 
				{	//save file with .ser extension
					FileOutputStream fos = new FileOutputStream(fileName+".ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(containerOfObjects); //save list of drawn shapes
					oos.flush();
					oos.close();
				}
				catch (IOException e1) 
				{  //show msg if unable to save
				  JOptionPane.showMessageDialog(container, "Something went wrong!");
				}
				
			}
			
			//call repaint to remove anything that might have been obscured by menus 
			drawingArea.repaint();
		}
	}

}
