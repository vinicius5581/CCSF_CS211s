/**Name: Victor Malchikov
 * File: LoadListener.java
 */

package hw.button;

import hw.CanvasSpace;
import hw.shape.ShapeBuilder;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**Class that allows user to load their old drawings. */
public class LoadListener extends BasicListener
{
	private JFileChooser fc; //fileChooser allows user to visually navigate to dir
	private JPanel container;
	private List<ShapeBuilder> sb; //container of drawn shapes 
	private CanvasSpace drawingArea;
	
	//**********************LoadListener()******************************************
	public LoadListener(JPanel container, CanvasSpace area)
	{
		super(container, area);
		this.container = container;
		drawingArea = area;
	}
	
	//*********************actionPerformed()**************************************
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		//default starting area is user's home directory
	    fc = new JFileChooser(System.getProperty("user.home"));
		//show files and directories
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		//allow user to see .ser extension 
		FileNameExtensionFilter ff = new FileNameExtensionFilter("ser", ".ser");
		//add filter to FileChooser
		fc.addChoosableFileFilter(ff);
		//get user's selection 
		int returnValue = fc.showOpenDialog(null);

		//make sure that user selected save button
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			//check what file user selected
			File file = fc.getSelectedFile();
			//get absolute path to file
			String fileName = file.getAbsolutePath();
			
			//make sure that there is a filename && it contains .ser extension 
			if((fc.getSelectedFile() != null) && (fileName.contains(".ser")))
			{
				//open file and draw the shapes 
				try 
				{
					FileInputStream fis = new FileInputStream(fileName);
					ObjectInputStream ois = new ObjectInputStream(fis);
					sb = (List<ShapeBuilder>)ois.readObject();
					ois.close();
					//save List of Shapes 
					drawingArea.setListOfShapes(sb);
	
				}
				catch (IOException | ClassNotFoundException e1) 
				{
				  JOptionPane.showMessageDialog(container, "Something went wrong!");
				}
				
			}
			else //if problem with file show message 
				JOptionPane.showMessageDialog(container, "Unable to open file.");
			
			//call update and repaint so user can see their drawing
			drawingArea.update(drawingArea.getGraphicsTool());
			drawingArea.repaint();

		}

	}
}
