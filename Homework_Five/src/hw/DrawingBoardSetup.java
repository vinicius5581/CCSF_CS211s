/**Name: Victor Malchikov
 * File; DrawingBoardSetup.java
 */
package hw;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Serializable;
import javax.swing.JFrame;

/**Class that creates the frame and adds all the components to the frame. */
public class DrawingBoardSetup extends JFrame implements Serializable 
{
	private CanvasSpace canvas;
	private DrawingBoardButtonContainer buttonContainer;
	
	//*****************************DrawingBoardSetup()******************************
	//constructor
	public DrawingBoardSetup()
	{
		setTitle("Drawing Board"); //title
		//get toolkit to help create size of the frame 
		Toolkit tk = Toolkit.getDefaultToolkit();
		//set size based on user's machine 
		Dimension screen = tk.getScreenSize();
		int width = (int)screen.getWidth();
		int height = (int)screen.getHeight();
		setSize((width/2)+100, (height/2)+100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create buttonContainer and drawing area 
		buildSetup();
		setLayout(new BorderLayout());

		//adding drawing area and buttons area to the frame 
		add(canvas, BorderLayout.CENTER);
		add(buttonContainer, BorderLayout.SOUTH);
		setResizable(false); //do not allow user to resize the application 
		setVisible(true);

	}
	
	//***********************************buildSetup()*******************************
	private void buildSetup()
	{
		canvas = new CanvasSpace(this);
		//buttons area that accepts drawing area as parameter 
		buttonContainer = new DrawingBoardButtonContainer(canvas);
		//setting size of buttons area
		buttonContainer.setPreferredSize(new Dimension(100,50));
		buttonContainer.setBackground(Color.gray);
	}

}
